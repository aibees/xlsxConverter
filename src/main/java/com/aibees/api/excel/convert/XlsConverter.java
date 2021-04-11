package com.aibees.api.excel.convert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import com.google.gson.*;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author aibees
 * Excel에서 CSV 파일로 변환
 * CSV에서 JSON으로 다시 변환할 것이기 때문에 String 상태로 반환해야 한다.
 * Sheet 별로 Read
 */
public class XlsConverter {

	/* Private Variable Declaration */
	private FileInputStream fs = null;
	private XSSFWorkbook workbook = null;
	private List<HashMap<String, String>> data = null;
	
	/**
	 * Constructor 1
	 * @param null
	 */
	
	public XlsConverter() {}
	
	/**
	 * 정해진 column으로 인해 vo는 만들 수 없는 상황.
	 * json을 활용하여 동적인 excel vo를 만들자
	 */
	// TODO : HEADER -> HASHMAP // BODY(ROWS) -> JSON
	
	/**
	 * data에서 Excel로 만들고자 할 때 빈 WorkBook 인스턴스를 생성
	 */
	public void setWorkBook() {
		this.workbook = new XSSFWorkbook();
	}
	
	/**
	 * Excel 파일을 받아 Workbook을 만들고자 할 때 xlsx을 받아 Workbook 생성
	 * @param xlsx
	 * @throws Exception
	 */
	public void setWorkBook(File xlsx) throws Exception {
		setFileStream(xlsx);
		this.workbook = new XSSFWorkbook(this.fs);
	}
	
	/**
	 * Excel로 내보내기 위한 데이터 가져오기
	 * @param data
	 */
	public void setData(List<HashMap<String, String>> data) {
		this.data = data;
	}
	
	// Excel to data
	public void readFile() {
		XSSFSheet curSheet;
		
		// Sheet idx
		int cnt_Sheet = this.workbook.getNumberOfSheets();
		
		for(int idx = 0; idx < cnt_Sheet; idx++) {
			curSheet = this.workbook.getSheetAt(idx);
			
			
		}
	}
	
	// data to Excel
	public File writeFile() {
		return null;
	}
	
	public File getWorkBook() {
		
		return writeFile();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String>getToCSV() {
		return null;
	}
	
	public List<HashMap<String, String>> getToKeyValue() {
		return this.data;
	}
	
	private void setFileStream(File file) throws Exception {
		this.fs = new FileInputStream(file);
	}
}
