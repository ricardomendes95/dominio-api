package com.api.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crm.services.interfaces.IResponsabilityLetterService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	IResponsabilityLetterService responsabilityLetterService;
	
	@GetMapping
	public String hello() {
//    	ResponsabilityLetter rl = container.getResponsabilityLetterRepository().getResponsabilityLetter();
//    	
//    	if (rl == null) {
//    		System.out.println("Null");
//    		return null;
//    	} else {
//    		System.out.println("Tem valor");
//    		return "tem valor";
//    	}
		
		return responsabilityLetterService.getHelloWorld();
    	
	}

}
