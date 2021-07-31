package com.api.crm;

import com.api.crm.database.IDatabase;
import com.api.crm.repositories.interfaces.IResponsabilityLetterRepository;

public interface IContainer {
	public IDatabase getSQLAnywhereDatabaseConnection();
	public IResponsabilityLetterRepository getResponsabilityLetterRepository();
}
