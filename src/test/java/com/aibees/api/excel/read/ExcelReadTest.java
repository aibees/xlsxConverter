package com.aibees.api.excel.read;

import com.aibees.api.excel.core.XlsControl;
import com.aibees.api.excel.core.excel.ExcelReader;

import java.io.File;

public class ExcelReadTest {

    public static void main(String[] args) {
        ExcelReader xlsReader = new ExcelReader();
        // read file
        try {
            xlsReader.setFile(new File("./test.xlsx"), true);
            int sheetCnt = xlsReader.getSheetSize();

            for(int idx = 0; idx < sheetCnt; idx++) {

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
