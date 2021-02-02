package com.cu.back.train.repository.core;

import lombok.Data;

@Data
public class ComboBoxInstituteModel {

	private String query;
	private String from;
	private String to;
	private String lang;
	private String currentValue;
	private Integer limit;
	private Integer countryId;
	private Integer provinceId;
	private Integer districtId;
	private Integer subDistrictId;
}

