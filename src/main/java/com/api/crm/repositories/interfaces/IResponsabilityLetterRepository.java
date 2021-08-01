package com.api.crm.repositories.interfaces;

import java.util.List;

import com.api.crm.model.ResponsabilityLetter;

public interface IResponsabilityLetterRepository {
	List<ResponsabilityLetter> getResponsabilityLetters(String lastUpdateDate, int crcType);
}