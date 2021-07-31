package com.api.crm.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.crm.database.IDatabase;
import com.api.crm.model.ResponsabilityLetter;
import com.api.crm.repositories.interfaces.IResponsabilityLetterRepository;

@Component
public class ResponsabilityLetterRepository implements IResponsabilityLetterRepository {
	@Autowired
	private IDatabase database;
	

	@Override
	public ResponsabilityLetter getResponsabilityLetter() {
		Connection connection = database.getConnection();
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("SELECT * FROM BETHADBA.geempre");
		
		
			ResultSet rs = statement.executeQuery();
	
			while (rs.next()) {				
				String currentDate = rs.getString("nome_emp"); // get first column returned
				System.out.println("Current Date from Sybase is : " + currentDate);
			}
			
			statement.close();
			
			return new ResponsabilityLetter();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return null;
	}
	
	@Override
	public String getHelloWorld() {
		return "Hello, world";
	}
	
}
