package com.cu.back.train.repository.core;

import java.util.List;
import java.util.Map;

import com.cu.back.train.utils.CoreUtils;

import lombok.Getter;

@Getter
public class Data {

	private Map<String, Object> data;

	private Data() {
	}

	public static Data of() {
		Data d = new Data();
		return d;
	}
	
	public static Data of(Map<String, Object> data) {
		Data d = new Data();
		d.data = data;
		return d;
	}

	public static Data of(List<Map<String, Object>> records) {
		Data d = new Data();
		d.data = (CoreUtils.isNotEmpty(records)) ? records.get(0) : null;
		return d;
	}
	
	public Data put(String key, Object value) {
		this.data.put(key, value);
		return this;
	}
	
	public Object get(String key) {
		return this.data.get(key);
	}

	public Data remove(String key) {
		this.data.remove(key);
		return this;
	}

	@Override
	public String toString() {
		return "Data [" + data + "]";
	}
	
}
