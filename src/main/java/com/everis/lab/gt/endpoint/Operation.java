package com.everis.lab.gt.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.lab.gt.endpoint.bean.OperationResponse;
import com.everis.lab.gt.endpoint.bean.PostRecordRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.everis.lab.gt.model.Record;
import com.everis.lab.gt.service.OperationService;

@RestController
public class Operation {
	
	@Autowired
	private OperationService operationService;
	
	public static final String SUCCESS = "sucesso";

	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/operation")
    public OperationResponse greeting(@RequestParam(value="name", defaultValue="trallalla") String name) {
    	logger.info("operation!");
        return new OperationResponse(SUCCESS);
    }
    
    @GetMapping("/record")
    public List<Record> getMapping() {
    	List<Record> a = operationService.findAll();    	
        return a;
    }
    
    @GetMapping("/recuerdalo")
    public List<Record> getCachedMapping() {
    	List<Record> a = operationService.findAllo();    	
        return a;
    }
    
    @PostMapping("/record")
    public Record postMapping(@RequestBody PostRecordRequest postRecordRequest) {

		Record record = postRecordRequest.convetToEntity();
        return operationService.save(record);    	
    }
	
}
