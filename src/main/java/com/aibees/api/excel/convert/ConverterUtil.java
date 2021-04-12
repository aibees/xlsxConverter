package com.aibees.api.excel.convert;

import com.aibees.api.excel.vo.HeaderVo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConverterUtil {

    // csv로 되어있는 데이터를 Map 형식으로 변환
    // Convert csv data to Hashmap data
    public Map<String, String> CsvToKeyValue(String[] headers, String[] row) {
        Map<String, String> result = new HashMap<String, String>();

        if(headers.length == row.length) {
            for(int idx = 0; idx < headers.length; idx++) {
                result.put(headers[idx], row[idx]);
            }
        } else {
            return null;
        }

        return result;
    }

    public void CsvToJson(String[] headers, String[] row) {

        return;
    }
}
