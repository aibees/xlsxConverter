package com.aibees.api.excel.convert;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;

public class RowUtil {

    private static RowUtil rowUtil = null;

    private RowUtil() { }

    public static synchronized RowUtil getInstance() {
        if(rowUtil == null) {
            rowUtil = new RowUtil();
        }

        return rowUtil;
    }

    public List<Cell> RowToList(Row row) {
        List<Cell> rowList = new ArrayList<Cell>();

        int idx = 0;

        while(true) {
            if(row.getCell(idx) == null) {
                break;
            } else {
                rowList.add(row.getCell(idx++));
            }
        }

        return rowList;
    }
}
