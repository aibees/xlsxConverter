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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // header
        sb.append(this.header.toString()).append("\r\n");
        // rows
        for(RowVo r : this.row) {
            String str = "| ";
            for(int i = 0; i < this.header.getHeaderSize(); i++) {
                CellVo col = this.header.getHeaderByIndex(i);
                str = str.concat(r.getRows().get(col).getValue() + " | ");
            }
            sb.append(str).append("\r\n");
        }
      return sb.toString();
    };
}
