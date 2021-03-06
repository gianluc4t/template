package com.everis.lab.gt.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.everis.lab.gt.model.Record;

@Component
public interface OperationRepository  extends CrudRepository<Record, Long> {

    List<Record> findByName(String name);

    @Cacheable("findByValue")
    List<Record> findByValue(int lastName);

    List<Record> findByNameAndValue(String name, int lastName);

    List<Record> findAll();
	
	}
