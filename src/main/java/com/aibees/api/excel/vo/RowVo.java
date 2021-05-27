package com.aibees.api.excel.vo;

import org.apache.poi.ss.usermodel.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowVo {

    private Map<CellVo, CellVo> rows = null;

    public RowVo() {
        this.rows = new HashMap();
    }

    public RowVo(Map<CellVo, CellVo> rows) {
        this.rows = rows;
    }

    public Map<CellVo, CellVo> getRows() { return this.rows; }

    public void setRows(Map<CellVo, CellVo> row) {
        this.rows = row;
    }

    public void addToRow(CellVo k, CellVo v) { this.rows.put(k, v); }

}
