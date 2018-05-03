package com.indra.ar.sales.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.ar.sales.domain.SaleBook;
import com.indra.ar.sales.services.Sales;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;

@RestController
@RequestMapping("/api/")
@Api(value = "Sales", description = "Rest API for sales operations", tags = "Books API")
public class SalesRestApi extends AbstractController{

	private static final String SALES_END_POINT = "/sales";
	
	@Autowired
	@Getter
	Sales saleService;
	
	@PostMapping(path = SALES_END_POINT)
	@ApiOperation(value = "Sale book", response = SaleBook.class)
	public void saleBook(@Valid @RequestBody SaleBook saleBook) {
		
		getSaleService().saleBook(saleBook);
		
	}
}
