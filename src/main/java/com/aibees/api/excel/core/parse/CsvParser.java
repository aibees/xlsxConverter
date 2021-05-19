package com.aibees.api.excel.core.parse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.aibees.api.excel.core.parse.listener.ParseListener;

/**
 * Csv to String[]
 * @author aibee
 *
 */
public class CsvParser implements ParseListener<List<String>> {

	// Variable
	public static final Character csvParser = ',';
	public static final Character csvStringParser = '\"';
	
	private static List<List<String>> result = new ArrayList<List<String>>();
	
	private StringBuilder sb = null;
	private boolean async = false;
	
	public CsvParser() {
		
	}
	
	/**
	 * 
	 * @param sb
	 * @param async - TRUE : 비동기식(Thread), FALSE : 동기식(Loop)
	 */
	public CsvParser(StringBuilder sb, boolean async) {
		this.sb = sb;
		this.async = async;
	}
	
	public void setData(StringBuilder sb) {
		this.sb = sb;
	}
	
	public List<List<String>> convert() {
		result.clear();
		
		String[] rows = this.sb.toString().split("/n");
		
		try {
		
			if(async) {
				// MultiThread
				// 기존 Row 순서가 바뀔 수 있음
				return convertAsynchronized(rows);
			}
			else {
				// 단일 Thread
				// 기존 문서 그대로 옮겨지지만 속도 현저하게 느림(뻑 갈수도 있음....)
				return convertSynchronized(rows);
			}	
		} catch(InterruptedException ire) {
			ire.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
    private List<List<String>> convertSynchronized(String[] rows) {
    	for(int idx = 0; idx < rows.length; idx++) {
    		result.add(process(rows[idx]));
    	}
    	
    	return result;
    }
    
    private List<List<String>> convertAsynchronized(String[] rows) throws Exception {
    	
    	System.out.println("Start converetAsynchronized Method");
    	
    	// thread ExecutorService 생성. thread 수는 10개로 고정
    	ThreadPoolExecutor taskService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    	
    	// 내부 task 클래스 생성. Callable -> 생성자로 
    	class task implements Callable<List<String>> {

    		String row = "";
    		
    		// 생성자와 함께 외부에서 처리대상 데이터 수입(?) 해옴
    		task(String r) {
    			this.row = r;
    		}

			public List<String> call() throws Exception {
				return process(this.row);
			}
    	}
    	
    	List<List<String>> result = new ArrayList<List<String>>();
    	
    	for(String row : rows) {
    		task t = new task(row);
    		Future<List<String>> futureResult = taskService.submit(t);
    		result.add(futureResult.get());
    	}
    	
    	taskService.shutdown();
    	
    	return result;
    }
	
	/**
	 * 단일 행 Parse & Convert to List
	 * @param pst
	 * @return
	 */
	private List<String> process(String pst) {
		List<String> result = new ArrayList<String>();
		
		String tmp = "";
		boolean f = false;
		
		for(int i = 0; i < pst.length(); i++) {
			char c = pst.charAt(i);
			
			if(c == csvStringParser) {
				if(f)
					f = false;
				else
					f = true;

				continue;
			}
			
			
			if(!f && c == csvParser) {
				result.add(tmp);
				tmp = "";
			}
			else {
				tmp += c;
			}
		}
		
		if(!tmp.isEmpty()) { result.add(tmp); }
		return result;
	}
}
