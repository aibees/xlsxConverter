package com.aibees.api.excel.core;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author aibees
 * Excel에서 CSV 파일로 변환
 * CSV에서 JSON으로 다시 변환할 것이기 때문에 String 상태로 반환해야 한다.
 * Sheet 별로 Read
 */
public class XlsControl {

	private File file = null;

	public XlsControl() {}
	
	/**
	 * 정해진 column으로 인해 vo는 만들 수 없는 상황.
	 * hashmap을 활용하여 동적인 excel vo를 만들자
	 */
	// TODO : HEADER -> HASHMAP // BODY(ROWS) -> JSON

	public void setFile(File file) {
		this.file = file;
	}


	// data to Excel
	public File writeFile() {
		return null;
	}

	public File getWorkBook() {

		return writeFile();
	}

}
