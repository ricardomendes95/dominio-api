package com.api.crm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crm.Container;
import com.api.crm.IContainer;
import com.api.crm.model.ResponsabilityLetter;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping
	public String hello() {
		IContainer container = new Container();
    	
    	ResponsabilityLetter rl = container.getResponsabilityLetterRepository().getResponsabilityLetter();
    	
    	if (rl == null) {
    		System.out.println("Null");
    		return null;
    	} else {
    		System.out.println("Tem valor");
    		return "tem valor";
    	}
    	
	}

}
