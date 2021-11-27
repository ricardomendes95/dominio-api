package com.api.crm.services.interfaces;

import com.api.crm.model.CompanyResponsabilityLatter;
import com.api.crm.model.ResponsabilityLetter;
import java.util.List;

public interface IResponsabilityLetterService {
   List<ResponsabilityLetter> getResponsabilityLetters(String lastUpdateDate, int crcType);

   CompanyResponsabilityLatter getCompany(int id);
}
