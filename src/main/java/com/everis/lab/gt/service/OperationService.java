package com.everis.lab.gt.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.lab.gt.model.Record;
import com.everis.lab.gt.repository.OperationRepository;

import javassist.NotFoundException;

@Service
public class OperationService {

	@Autowired
	private OperationRepository operationRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public Record findById(Long id) throws NotFoundException {
		Record result = null;
		Optional<Record> optResult = operationRepository.findById(id);
		if (optResult.isPresent()) {
			result = optResult.get();
		} else {
			throw new NotFoundException(String.format("findById(%d) returning no result!", id));
		}
		return result;
	}
	
	public Record save(Record record) {
		logger.info("saving one .... ");
		
		record = operationRepository.save(record);
		return record;
	}
	
	public List<Record> findAll() {
		List<Record> result = (List<Record>) operationRepository.findAll();

		logger.info("returning + " + result.size());
		return result;
	}
}
