package com.api.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.crm.model.ResponsabilityLetter;
import com.api.crm.services.interfaces.IResponsabilityLetterService;

@RestController
@RequestMapping("/responsabilityLetter")
public class ResponsabilityLetterController {

	@Autowired
	IResponsabilityLetterService responsabilityLetterService;

	@GetMapping
	public List<ResponsabilityLetter> listResponsabilityLetters(@RequestParam("lastUpdateDate") String lastUpdateDate, @RequestParam("crcType") int crcType) {
		return responsabilityLetterService.getResponsabilityLetters(lastUpdateDate, crcType);
	}

}
