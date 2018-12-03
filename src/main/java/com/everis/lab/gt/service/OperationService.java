package com.everis.lab.gt.service;

import java.util.List;

import com.everis.lab.gt.model.Record;

import javassist.NotFoundException;

public interface OperationService {

	public Record findById(Long id) throws NotFoundException;
	
	public Record save(Record record);
	
	public List<Record> findAll();
	
	public List<Record> findAllo();
	
}
