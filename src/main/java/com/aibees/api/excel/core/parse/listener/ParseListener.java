package com.aibees.api.excel.core.parse.listener;

import java.util.List;

public interface ParseListener<T> {
	
	// Method
	public List<T> convert();
}
