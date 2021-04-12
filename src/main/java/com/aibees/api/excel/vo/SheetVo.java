package com.aibees.api.excel.vo;

public class SheetVo<K, V> {

    private HeaderVo    header = null;
    private RowVo<K, V> row    = null;

    public SheetVo() { }

    public SheetVo(HeaderVo header, RowVo<K, V> row) {
        this.header = header;
        this.row = row;
    }

    public HeaderVo getHeader() {
        return header;
    }

    public RowVo<K, V> getRow() {
        return row;
    }

    public void setHeader(HeaderVo header) {
        this.header = header;
    }

    public void setRow(RowVo<K, V> row) {
        this.row = row;
    }
}
