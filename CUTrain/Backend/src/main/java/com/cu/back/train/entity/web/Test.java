package com.cu.back.train.entity.web;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "test")
public class Test implements Serializable {

	private static final long serialVersionUID = 7900602201145160389L;

	@Id
	@GeneratedValue(generator = "test_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

}
