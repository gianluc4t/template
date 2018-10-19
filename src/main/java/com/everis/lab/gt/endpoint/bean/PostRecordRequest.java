package com.everis.lab.gt.endpoint.bean;

import com.everis.lab.gt.model.Record;

public class PostRecordRequest {

	private String name;
	private int value;

	public PostRecordRequest() {
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public Record convetToEntity() {
		return new Record(name, value);
	}

}
