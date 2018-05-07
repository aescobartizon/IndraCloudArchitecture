package com.indra.ar.delivery.listener;

import javax.jms.Session;

import org.apache.activemq.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.indra.ar.sales.domain.SaleBook;

import lombok.Getter;

@Component
public class JmsSaleListener {

	
	@Getter
	private static Logger log = LoggerFactory.getLogger(JmsSaleListener.class);
	
	@JmsListener(destination = "Consumer.Delivery.VirtualTopic.SalesTopic")
	public void saleBook(@Payload SaleBook saleBook, @Headers MessageHeaders headers, Message message,
			Session session) {

		//getLog().info(("Libro vendido <" + saleBook + ">"));

	}
}
