package com.api.crm;

import com.api.crm.database.IDatabase;
import com.api.crm.database.SQLAnywhereDatabaseConnection;
import com.api.crm.repositories.ResponsabilityLetterRepository;
import com.api.crm.repositories.interfaces.IResponsabilityLetterRepository;

public class Container implements IContainer {
	private IDatabase sqlAnywhereDatabaseConnection;
	private IResponsabilityLetterRepository responsabilityLetterRepository;

	@Override
	public IDatabase getSQLAnywhereDatabaseConnection() {
		if (sqlAnywhereDatabaseConnection == null) {
			sqlAnywhereDatabaseConnection = new SQLAnywhereDatabaseConnection();
		}
		
		return sqlAnywhereDatabaseConnection;
	}

	@Override
	public IResponsabilityLetterRepository getResponsabilityLetterRepository() {
		if (responsabilityLetterRepository == null) {
			getSQLAnywhereDatabaseConnection();
			
			responsabilityLetterRepository = new ResponsabilityLetterRepository(sqlAnywhereDatabaseConnection.getConnection());
		}
		
		return responsabilityLetterRepository;
	}

}
