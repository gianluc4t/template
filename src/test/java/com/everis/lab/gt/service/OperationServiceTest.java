package com.everis.lab.gt.service;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.everis.lab.gt.App;
import com.everis.lab.gt.model.Record;
import com.everis.lab.gt.repository.OperationRepository;
import com.everis.lab.gt.service.impl.OperationServiceImpl;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class OperationServiceTest {

	private static final String TEST_NAME = "testName";
	private static final int TEST_VALUE = 123;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@InjectMocks
	private OperationServiceImpl operationService;

	@Mock 
    OperationRepository operationRepository; 
	
	@Before
	public void init_mocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {

		Record data = new Record (TEST_NAME,123);
		Record expected = new Record (1L, TEST_NAME, 555);
		logger.info("test xxxx");
		
		when(operationRepository.save(data)).thenReturn(expected);
		
		Record result = operationService.save(data);
		logger.info("data = " + data.toString());
		logger.info("expected = " + expected.toString());
		logger.info("result = " + result.toString());
		assertTrue(result.equals(expected));
	}
}
