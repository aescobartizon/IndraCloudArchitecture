package com.indra.ar.notificationsservice.jms.listener;

import javax.jms.Session;

import org.apache.activemq.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.indra.ar.books.domain.Email;

@Component
public class JmsEmailListener {

	@JmsListener(destination = "MailBox.queue")
	@SendTo("outbound.queue")
	public String receiveMessage(@Payload Email email, @Headers MessageHeaders headers, Message message,
			Session session) {

		System.out.println("Received <" + email + ">");

		return "Mail OK";
	}
	
}
