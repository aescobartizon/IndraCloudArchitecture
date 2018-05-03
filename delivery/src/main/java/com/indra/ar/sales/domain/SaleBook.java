package com.indra.ar.sales.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SaleBook implements Serializable{
	
	public SaleBook() {
		super();
	}

	
	
	public SaleBook(String customer, String isbn, int amount) {
		super();
		this.customer = customer;
		this.isbn = isbn;
		this.amount = amount;
	}

	private static final long serialVersionUID = -1706751323203343397L;

	private String customer;
	
	private String isbn;
	
	private int amount;

}
