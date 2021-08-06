package com.api.crm.services.interfaces;

import java.util.List;

import com.api.crm.model.CompanyResponsabilityLatter;
import com.api.crm.model.ResponsabilityLetter;

public interface IResponsabilityLetterService {
	List<ResponsabilityLetter> getResponsabilityLetters(String lastUpdateDate, int crcType);

	CompanyResponsabilityLatter getCompany(int id);
}
