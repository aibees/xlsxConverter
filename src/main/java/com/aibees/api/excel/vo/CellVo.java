package com.aibees.api.excel.vo;

public class CellVo {
    private String value;
    private boolean merged;
    private int mergeIdx;

    public CellVo() {}

    public CellVo(String value, boolean merged, int mergeIdx) {
        this.value = value;
        this.merged = merged;
        this.mergeIdx = mergeIdx;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

    public int getMergeIdx() {
        return mergeIdx;
    }

    public void setMergeIdx(int mergeIdx) {
        this.mergeIdx = mergeIdx;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
