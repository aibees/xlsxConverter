package com.aibees.api.excel.vo;

import java.util.List;
import java.util.Map;

public class RowVo<K, V> {

    private List<Map<K, V>> rows = null;

    public RowVo() { }

    public RowVo(List<Map<K, V>> rows) {
        this.rows = rows;
    }

    public List<Map<K, V>> getRows() { return this.rows; }

    public void setRows(List<Map<K, V>> row) {
        this.rows = row;
    }
}
