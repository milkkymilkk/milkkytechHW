package com.cu.back.train.repository.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public class GridData {

	private List<Map<String, Object>> records;
	private long total;
	
	private GridData() {
	}

	public static GridData of(List<Map<String, Object>> records) {
		GridData d = new GridData();
		d.records = records != null ? records : new ArrayList<>();
		return d;
	}

	public static GridData of(List<Map<String, Object>> records, long total) {
		GridData data = new GridData();
		data.records = records != null ? records : new ArrayList<>();
		data.total = total;
		return data;
	}
}
