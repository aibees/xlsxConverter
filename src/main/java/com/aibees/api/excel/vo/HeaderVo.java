package com.aibees.api.excel.vo;

import java.util.List;

public class HeaderVo {
    private List<CellVo> header = null; // List -> LinkedList

    public HeaderVo() { }

    public HeaderVo(List<CellVo> header) {
        this.header = header;
    }

    public List<CellVo> getHeader() { return this.header; }

    public void setHeader(List<CellVo> header) {
        this.header = header;
    }

    public CellVo getHeaderByIndex(int idx) { return this.header.get(idx); }

    public int getHeaderSize() {
        return header.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("| ");
        for(CellVo c : this.header) {
            sb.append(c.toString() + " | ");
        }

        return sb.toString();
    }

    public void printHeader() {
        System.out.print("| ");
        for(CellVo c : this.header) {
            System.out.print(c.toString() + " | ");
        }
        System.out.println();
    }
}
