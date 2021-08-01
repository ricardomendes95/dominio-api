package com.api.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.crm.model.ResponsabilityLetter;
import com.api.crm.repositories.interfaces.IResponsabilityLetterRepository;
import com.api.crm.services.interfaces.IResponsabilityLetterService;

@Component
public class ResponsabilityLetterService implements IResponsabilityLetterService {
	@Autowired
	IResponsabilityLetterRepository responsabilityLetterRepository;
	
	@Override
	public List<ResponsabilityLetter> getResponsabilityLetters(String lastUpdateDate, int crcType) {
		return responsabilityLetterRepository.getResponsabilityLetters(lastUpdateDate, crcType);
	}
	

}
