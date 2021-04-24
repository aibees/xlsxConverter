package com.aibees.api.excel.core.excel;

import com.aibees.api.excel.convert.RowUtil;
import com.aibees.api.excel.vo.HeaderVo;
import com.aibees.api.excel.vo.SheetVo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ExcelReader extends ExcelCommon {

    private boolean isHeader = true;
    XSSFWorkbook wb = null;

    /**
     * Data Variable for `One` Sheet
     */
    private HeaderVo headers = null; // List<Cell>
    private List<SheetVo> sheets = null;

    public void setFile(File file) throws Exception {
        this.wb = getWorkBook(file);
        this.isHeader = true;
    }

    /**
     * Method that can set a header presence
     * @param file
     * @param isHeader
     */
    public void setFile(File file, boolean isHeader) throws Exception {
        this.wb = getWorkBook(file);
        this.isHeader = isHeader;
    }

    public int getSheetSize() throws Exception {
        return this.wb.getNumberOfSheets();
    }

    public String[] toCSV() {
        String[] rows = null;

        return rows;
    }

    public void getKeyValue(int sheet) {
        ToKeyValue(sheet);
    }

    private void ToKeyValue(int sheetNum) {
        try {
            XSSFSheet sheet = this.wb.getSheetAt(sheetNum);

            headers = new HeaderVo();

            if(isHeader) { // True : Header 존재
                headers.setHeader(RowUtil.getInstance().RowToList(sheet.getRow(0)));
            }

            headers.printHeader();

            int rowCnt = sheet.getLastRowNum();

            for(int i = 1; i <= rowCnt; i++) {
                Row r = sheet.getRow(i);
                System.out.print("| ");
                for(int idx = 0; idx < headers.getHeaderSize(); idx++) {
                    Cell c = r.getCell(idx);
                    System.out.print(c.toString() + " | ");
                }
                System.out.println();
            }



        } catch(Exception e) {
         e.printStackTrace();
        }
    }
}
