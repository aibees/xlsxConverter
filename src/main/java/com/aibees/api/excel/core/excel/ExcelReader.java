package com.aibees.api.excel.core.excel;

import com.aibees.api.excel.function.ReadFunction;
import com.aibees.api.excel.convert.RowUtil;
import com.aibees.api.excel.vo.HeaderVo;
import com.aibees.api.excel.vo.SheetVo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.List;

public class ExcelReader extends ExcelCommon {

    private boolean isHeader = true;
    private ReadFunction func = new ReadFunction();
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
                Row r = sheet.getRow(i); // 각 Row 별
                if(r.getLastCellNum() < 0)
                    break;
                System.out.print("| ");
                for(int idx = 0; idx < headers.getHeaderSize(); idx++) { // Column loop라 생각하면 됨

                    // Determine if this cell is in a merged cell
                    Integer mergedCellIndex = this.func.getIndexIfCellIsInMergedCells(sheet, i, idx);

                    if(mergedCellIndex != null) {
                        CellRangeAddress cell = sheet.getMergedRegion(mergedCellIndex);
                        System.out.print("[Merged_" + mergedCellIndex + "]");
                    }
                    //System.out.print("idx : " + idx + ", ");
                    Cell c = r.getCell(idx, Row.RETURN_NULL_AND_BLANK);
                    if(c == null)
                        continue;

                    System.out.print(c.toString() + " | ");
                }
                System.out.println();
            }



        } catch(Exception e) {
         e.printStackTrace();
        }
    }
}
