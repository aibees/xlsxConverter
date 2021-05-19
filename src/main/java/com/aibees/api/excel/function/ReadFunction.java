package com.aibees.api.excel.function;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

public class ReadFunction {

    // 병합 셀인지 확인하는 Function
    // Get the index of the merged cell in all the merged cells
    public Integer getIndexIfCellIsInMergedCells(Sheet sheet, int row, int column) {
        int MergedRegions = sheet.getNumMergedRegions();

        for(int i = 0; i < MergedRegions; i++) {
            CellRangeAddress mergedCell = sheet.getMergedRegion(i);

            if(mergedCell.isInRange(row, column)) {
                return i;
            }
        }
        return null;
    }

    // 병합된 셀의 Contents Read
    public String readContentFromMergedCells(Sheet sheet, CellRangeAddress mergedCell) {
        if(mergedCell.getFirstColumn() != mergedCell.getLastRow()) {
            return null;
        }

        return sheet.getRow(mergedCell.getFirstRow()).getCell(mergedCell.getFirstColumn()).getStringCellValue();
    }
}
