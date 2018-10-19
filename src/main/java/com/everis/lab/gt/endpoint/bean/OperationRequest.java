package com.everis.lab.gt.endpoint.bean;

public class OperationRequest {

	private String value;

	public OperationRequest() {
		super();
	}

	public OperationRequest(String value) {
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
