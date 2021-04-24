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

    public int getHeaderSize() {
        return header.size();
    }

    public void printHeader() {
        System.out.print("| ");
        for(Cell c : this.header) {
            System.out.print(c.toString() + " | ");
        }
        System.out.println();
    }
}
