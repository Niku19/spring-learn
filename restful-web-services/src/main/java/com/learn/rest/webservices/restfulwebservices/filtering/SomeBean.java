package com.learn.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties will ignore the fields specified
// @JsonIgnoreProperties("field1")
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	private String field1;
	// @JsonIgnore will remove this field while creating json object
	// @JsonIgnore
	private String field2;
	private String field3;
	
	public SomeBean(String field1, String field2, String field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
}
