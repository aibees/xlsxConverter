package com.aibees.api.excel.core.parse;

import java.util.List;

import com.aibees.api.excel.core.parse.CsvParser;

public class CsvParserTest {

	private static CsvParser cp;
	
	public static void main(String[] args) {
		testProcess();
	}
	
	public static void testProcess() {
		String testRow1 = "10,\"[A,아](백, 인프라)지불시스템DB #1\",10.253.42.193,\"[DR](백, 인프라) 지불시스테DB\",OS,DB_TESTER/n";
		String testRow2 = "11,\"[A,아](백, 인프라)지불시스템DB #1\",10.253.42.195,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow3 = "12,\"[A,아](백, 인프라)지불시스템DB #1\",10.253.42.230,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow4 = "13,\"[A,아](백, 인프라)지불시스템DB #1\",10.253.42.69,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow5 = "14,\"[A,아](백, 인프라)지불시스템DB #1\",10.253.42.68,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow6 = "15,\"[A,아](백, 인프라)지불시스템DB #1\",10.253.42.67,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow7 = "16,\"[A,아](백, 인프라)지불시스템DB #2\",174.100.29.25,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow8 = "17,\"[A,아](이)지불시스템DB #1\",10.253.42.67,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow9 = "18,\"[A,아](백)지불시스템DB #1\",10.253.42.67,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow10 = "101,\"[p,아](백, 인프라)지불시스템DB #1\",106.253.42.193,\"[DR](백, 인프라) 지불시스테DB\",OS,DB_TESTER/n";
		String testRow12 = "111,\"[p,아](백, 인프라)지불시스템DB #1\",107.253.42.195,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow13 = "121,\"[p,아](백, 인프라)지불시스템DB #1\",108.253.42.230,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow14 = "131,\"[p,아](백, 인프라)지불시스템DB #1\",104.253.42.69,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow15 = "141,\"[p,아](백, 인프라)지불시스템DB #1\",103.253.42.68,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow16 = "151,\"[p,아](백, 인프라)지불시스템DB #1\",102.253.42.67,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow17 = "161,\"[p,아](백, 인프라)지불시스템DB #2\",1724.100.29.25,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow18 = "171,\"[p아](이)지불시스템DB #1\",10.253.42.67,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		String testRow19 = "181,\"[p,아](백)지불시스템DB #1\",10.253.42.67,\"[DR](백, 인프라) 지불시스템DB\",OS,DB_TESTER/n";
		StringBuilder sb = new StringBuilder();
		sb.append(testRow1);
		sb.append(testRow2);
		sb.append(testRow3);
		sb.append(testRow4);
		sb.append(testRow5);
		sb.append(testRow6);
		sb.append(testRow7);
		sb.append(testRow8);
		sb.append(testRow9);
		sb.append(testRow10);
		sb.append(testRow12);
		sb.append(testRow13);
		sb.append(testRow14);
		sb.append(testRow15);
		sb.append(testRow16);
		sb.append(testRow17);
		sb.append(testRow18);
		sb.append(testRow19);
		
		cp = new CsvParser(sb, true);
		
		List<List<String>> result = cp.convert();
		
		for(List<String> l : result) {
			for(String str : l) { System.out.print(str + " | "); }
			System.out.println();
		}
		
		
		
	}
}
