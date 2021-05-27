package com.aibees.api.excel.read;

import com.aibees.api.excel.core.XlsControl;
import com.aibees.api.excel.core.excel.ExcelReader;
import com.aibees.api.excel.vo.SheetVo;

import java.io.File;

public class ExcelReadTest {

    public static void main(String[] args) {
        ExcelReader xlsReader = new ExcelReader();
        // read file
        try {
            xlsReader.setFile(new File("./test1.xlsx"), true);
            int sheetCnt = xlsReader.getSheetSize();

            SheetVo sheetVo = xlsReader.getKeyValueFromFile(0);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
