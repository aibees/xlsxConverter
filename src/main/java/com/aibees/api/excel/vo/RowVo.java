package com.aibees.api.excel.vo;

import org.apache.poi.ss.usermodel.Cell;

import java.util.List;
import java.util.Map;

public class RowVo {

    private List<Map<Cell, Cell>> rows = null;

    public RowVo() { }

    public RowVo(List<Map<Cell, Cell>> rows) {
        this.rows = rows;
    }

    public List<Map<Cell, Cell>> getRows() { return this.rows; }

    public void setRows(List<Map<Cell, Cell>> row) {
        this.rows = row;
    }
}
