package com.cu.back.train.repository.core;

import java.util.HashMap;
import java.util.Map;

public class SqlParams {

	Map<String, Object> params;
	
	private SqlParams() {
		params = new HashMap<>();
	}
	
	public static SqlParams create() {
		return new SqlParams();
	}
	
	public static SqlParams create(String name, Object value) {
		return new SqlParams().add(name, value);
	}
	
	public static SqlParams create(PageModel model) {
		SqlParams params = new SqlParams();
		params.params.put("start_", model.getPageNumber() - 1);
		params.params.put("limit_", model.getPageSize());
		params.params.put("offset_", (model.getPageNumber() - 1) * model.getPageSize());
		return params;
	}
	
	public static SqlParams create(ComboBoxModel model) {
		SqlParams params = new SqlParams();
		params.params.put("query", "%" + model.getQuery() + "%");
		params.params.put("from", model.getFrom());
		params.params.put("to", model.getTo());
		params.params.put("lang", model.getLang());
		params.params.put("currentValue", model.getCurrentValue());
		params.params.put("limit", model.getLimit());
		return params;
	}
	
	public static SqlParams create(ComboBoxInstituteModel model) {
		SqlParams params = new SqlParams();
		params.params.put("query", "%" + model.getQuery() + "%");
		params.params.put("from", model.getFrom());
		params.params.put("to", model.getTo());
		params.params.put("lang", model.getLang());
		params.params.put("currentValue", model.getCurrentValue());
		params.params.put("limit", model.getLimit());
		params.params.put("countryId", model.getCountryId());
		params.params.put("provinceId", model.getProvinceId());
		params.params.put("districtId", model.getDistrictId());
		params.params.put("subDistrictId", model.getSubDistrictId());
		return params;
	}
	
	public SqlParams add(String name, Object value) {
		this.params.put(name, value);
		return this;
	}
	
	Map<String, Object> getParams() {
		return this.params;
	}
}
