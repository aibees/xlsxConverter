package com.aibees.api.excel.core.excel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelCommon {

    /**
     * Return empty Workbook if method with no parameter is called
     * @return empty WorkBook
     */
    public XSSFWorkbook getWorkBook() {
        return new XSSFWorkbook();
    }

    /**
     * Return WorkBook made of File(parameter)
     *
     * @param file
     * @return
     * @throws Exception
     */
    public XSSFWorkbook getWorkBook(File file) throws Exception {
        return new XSSFWorkbook(new FileInputStream(file));
    }
}
