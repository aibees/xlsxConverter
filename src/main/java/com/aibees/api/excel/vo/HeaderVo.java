package com.aibees.api.excel.vo;

import org.apache.poi.ss.usermodel.Cell;

import java.util.List;

public class HeaderVo {
    private List<Cell> header = null;

    public HeaderVo() { }

    public HeaderVo(List<Cell> header) {
        this.header = header;
    }

    public List<Cell> getHeader() { return this.header; }

    public void setHeader(List<Cell> header) {
        this.header = header;
    }

    public int getCnt() { return this.header.size(); }
}
