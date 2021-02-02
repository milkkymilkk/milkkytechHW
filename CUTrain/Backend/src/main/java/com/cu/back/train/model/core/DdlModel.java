package com.cu.back.train.model.core;

import lombok.Data;

@Data
public class DdlModel {

    private String value;
    private Integer valueI;
    private String text;
    private Boolean active;
    private String preNameTha;
    private String preNameEng;
    private String path;
    private String preNameGenderCode;
    private String studentTypeCode;
    private double gpa;
    private Integer countryId;
    private Integer postalCodeId;
    private String educationTypeCode;
    private String majorCode;
    private String proCode;
    private String planCode;
    private String systemStudyType;
    private String trackCode;
}
