package com.indra.ar.sales.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import lombok.Getter;

public class AbstractService {

	
	@Getter
	private static Logger log = LoggerFactory.getLogger(AbstractService.class);
	
	@Autowired
	JmsTemplate jmsTemplate; 
	
	public JmsTemplate getJmsTemplate() {
		//jmsTemplate.setPubSubDomain(Boolean.TRUE);
		return jmsTemplate;
	}
}
