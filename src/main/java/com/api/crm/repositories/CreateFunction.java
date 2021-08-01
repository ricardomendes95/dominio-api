package com.api.crm.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.crm.database.IDatabase;
import com.api.crm.repositories.interfaces.ICreateFunction;

@Component
public class CreateFunction implements ICreateFunction {
	
	@Autowired
	private IDatabase database;

	@Override
	public void createGetLastCompanyUpdate() {
		Connection connection = database.getConnection();

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(getGetLastCompanyUpdateSQL());
			
			statement.executeQuery();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void dropGetLastCompanyUpdate() {
		Connection connection = database.getConnection();

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("DROP FUNCTION get_last_update;");
			
			statement.executeQuery();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public String getGetLastCompanyUpdateSQL() {
		return "CREATE TEMPORARY FUNCTION get_last_update(@emp_id INT, @field INT, @lastUpdateDate DATE)"
				+ "RETURNS VARCHAR(255) "
				+ "AS "
				+ "BEGIN "
				+ "	DECLARE @data VARCHAR(255) "
				+ "	SET @data = (SELECT para FROM bethadba.GEEMPRE_ALTERACAO GEEM "
				+ "	INNER JOIN ( "
				+ "		SELECT CODI_EMP, max(DATA_ALTERACAO) AS MAX_DATE "
				+ "		FROM bethadba.GEEMPRE_ALTERACAO "
				+ "		GROUP BY CODI_EMP "
				+ "	) AUXGEEM ON GEEM.CODI_EMP = AUXGEEM.CODI_EMP AND GEEM.DATA_ALTERACAO = AUXGEEM.MAX_DATE "
				+ "	WHERE CAMPO = @field AND GEEM.CODI_EMP = @emp_id AND GEEM.DATA_ALTERACAO <= @lastUpdateDate) "
				+ "	RETURN @data "
				+ "END;";
	}
}
