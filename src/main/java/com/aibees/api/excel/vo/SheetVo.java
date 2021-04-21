package com.aibees.api.excel.vo;

import java.util.List;

public class SheetVo {

    private HeaderVo    header = null;
    private List<RowVo> row    = null;

    public SheetVo() { }

    public SheetVo(HeaderVo header, List<RowVo> row) {
        this.header = header;
        this.row = row;
    }

    public HeaderVo getHeader() {
        return header;
    }

    public List<RowVo> getRow() {
        return row;
    }

    public void setHeader(HeaderVo header) {
        this.header = header;
    }

    public void setRow(List<RowVo> row) {
        this.row = row;
    }
}
