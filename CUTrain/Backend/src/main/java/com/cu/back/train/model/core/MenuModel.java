package com.cu.back.train.model.core;

import lombok.Data;

@Data
public class MenuModel {
	private String Id;
	private String Code;
	private String Name;
	private String Icon;
	private String Url;
	private String Parent;
}
