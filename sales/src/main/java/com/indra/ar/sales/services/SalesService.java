package com.indra.ar.sales.services;

import java.util.Date;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.indra.ar.sales.conf.JmsBrokerConfig;
import com.indra.ar.sales.domain.SaleBook;

import lombok.Getter;

@Service
public class SalesService extends AbstractService implements Sales{

	
	@Getter
	private static Logger log = LoggerFactory.getLogger(SalesService.class);
	
	@Override
	public void saleBook(SaleBook saleBook) {
		getLog().info(new Date().toGMTString());
		for (int i = 0; i < 10000; i++) {
			getJmsTemplate().convertAndSend(new ActiveMQTopic(JmsBrokerConfig.SALES_TOPIC), saleBook);
		}
		getLog().info(new Date().toGMTString());
	}
}
