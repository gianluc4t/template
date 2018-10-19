package com.everis.lab.gt.endpoint.bean;

public class OperationResponse {

	private String value;

	public OperationResponse() {
		super();
	}

	public OperationResponse(String value) {
		this();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
