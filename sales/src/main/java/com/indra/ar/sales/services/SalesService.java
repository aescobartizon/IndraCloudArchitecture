package com.indra.ar.sales.services;

import org.springframework.stereotype.Service;

import com.indra.ar.sales.domain.SaleBook;

@Service
public class SalesService extends AbstractService implements Sales{

	@Override
	public void saleBook(SaleBook saleBook) {
		getJmsTemplate().convertAndSend(com.indra.ar.sales.conf.JmsBrokerConfig.SALES_TOPIC,saleBook);
	}
}
