package com.everis.lab.gt.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.everis.lab.gt.model.Record;
import com.everis.lab.gt.repository.OperationRepository;
import com.everis.lab.gt.service.OperationService;

import javassist.NotFoundException;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationRepository operationRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
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
	
	@Override
	public Record save(Record record) {
		logger.info("saving one .... ");
		
		record = operationRepository.save(record);
		return record;
	}

	@Override
	public List<Record> findAll() {
		List<Record> result = (List<Record>) operationRepository.findAll();

		logger.info("returning " + result.size());
		return result;
	}

	@Override
    @Cacheable("records")
	public List<Record> findAllo() {
		logger.info("findAllozzzz ");
		List<Record> result = (List<Record>) operationRepository.findAll();

		logger.info("returningmvn clean"
				+ " " + result.size());
		return result;
	}
}
