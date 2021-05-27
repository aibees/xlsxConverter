package com.aibees.api.excel.core.excel;

import com.aibees.api.excel.function.ReadFunction;
import com.aibees.api.excel.vo.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader extends ExcelCommon {

    private boolean isHeader = true;
    private final ReadFunction func = new ReadFunction();
    XSSFWorkbook wb = null;

    /**
     * Data Variable for `One` Sheet
     */
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

    public SheetVo getKeyValueFromFile(int sheet) {
        SheetVo sheetVo = ToVo(sheet);
        System.out.println("SheetVo Print");
        System.out.println(sheetVo.toString());
        return sheetVo;
    }

    public String getHtml() {
        StringBuilder sb = new StringBuilder();



        return sb.toString();
    }

    private SheetVo ToVo(int sheetNum) {
        HeaderVo headers;
        SheetVo sheetVo = new SheetVo();

        int rowStart = 0;

        try {
            XSSFSheet sheet = this.wb.getSheetAt(sheetNum);

            /* ------------------------------------- *
             * -------- Header Read Start ---------- *
             * ------------------------------------- */
            headers = new HeaderVo();

            if(isHeader) { // True : Header 존재
                headers.setHeader(func.RowToList(sheet));
                sheetVo.setHeader(headers);
                rowStart++;
            } else {
                sheetVo.setHeader(null);
            }

            /* ------------------------------------- *
             * --------- Row Read Start ------------ *
             * ------------------------------------- */
            int rowCnt = sheet.getLastRowNum(); // 전체 Row 수 Count(Header 포함)
            List<RowVo> rowVoList = new ArrayList<RowVo>();

            for(int i = rowStart; i <= rowCnt; i++) { // 각 Row 별 loop
                Row r = sheet.getRow(i);
                RowVo rowVo = new RowVo();

                if(r.getLastCellNum() < 0) // value가 하나도 없으면 -1로 출력됨
                    break;

                for(int idx = 0; idx < r.getLastCellNum(); idx++) { // Column loop
                    boolean mergeFlag = false;
                    // Determine if this cell is in a merged cell
                    Integer mergedCellIndex = this.func.getIndexIfCellIsInMergedCells(sheet, i, idx);

                    if(mergedCellIndex != null) { mergeFlag = true; }

                    Cell c = r.getCell(idx, Row.RETURN_NULL_AND_BLANK);
                    rowVo.addToRow(
                            headers.getHeaderByIndex(idx), // key
                            new CellVo(c.toString(),       // value
                                       mergeFlag   ,
                                       ((mergedCellIndex != null)? mergedCellIndex :(-1))
                            )
                    );
                }
                rowVoList.add(rowVo);
            }
            sheetVo.setRow(rowVoList);

        } catch(Exception e) {
         e.printStackTrace();
        }

        return sheetVo;
    }
}
