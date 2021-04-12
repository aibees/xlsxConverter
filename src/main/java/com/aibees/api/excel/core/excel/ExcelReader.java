package com.aibees.api.excel.core.excel;

import com.aibees.api.excel.convert.RowUtil;
import com.aibees.api.excel.vo.HeaderVo;
import com.aibees.api.excel.vo.SheetVo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ExcelReader extends ExcelCommon {

    private File file = null;
    private boolean isHeader = true;

    /**
     * Data Variable for `One` Sheet
     */
    private HeaderVo headers = null;
    private List<Map<String, String>> rows = null;
    private SheetVo<String, String> sheet = null;
    private List<SheetVo<String, String>> sheets = null;

    public void setFile(File file) {
        this.file = file;
        this.isHeader = true;
    }

    /**
     * Method that can set a header presence
     * @param file
     * @param isHeader
     */
    public void setFile(File file, boolean isHeader) {
        this.file = file;
        this.isHeader = isHeader;
    }

    public int getSheetSize() throws Exception {
        return getWorkBook(this.file).getNumberOfSheets();
    }

    public String[] toCSV() {
        String[] rows = null;

        return rows;
    }

    private void ToKeyValue(int sheetNum) {
        try {
            XSSFWorkbook wb = getWorkBook(this.file);
            XSSFSheet sheet = wb.getSheetAt(sheetNum);

            headers = new HeaderVo();

            if(isHeader) {
                headers.setHeader(RowUtil.getInstance().RowToList(sheet.getRow(0)));
            }

        } catch(Exception e) {
         e.printStackTrace();
        }
    }
}
