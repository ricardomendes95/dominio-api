package com.api.crm.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.crm.database.IDatabase;
import com.api.crm.model.CompanyResponsabilityLatter;
import com.api.crm.model.ResponsabilityLetter;
import com.api.crm.repositories.interfaces.ICreateFunction;
import com.api.crm.repositories.interfaces.IResponsabilityLetterRepository;

@Component
public class ResponsabilityLetterRepository implements IResponsabilityLetterRepository {
	@Autowired
	private IDatabase database;
	
	@Autowired
	private ICreateFunction createFunction;
	

	@Override
	public List<ResponsabilityLetter> getResponsabilityLetters(String lastUpdateDate, int crcType) {
		Connection connection = database.getConnection();
		
		List<ResponsabilityLetter> responsabilityLetterList = new ArrayList<>();
		
		PreparedStatement statement = null;
		try {
			String crcColumn = crcType == 1 ? "GECONTADOR.RCRC_CON" : "GECONTADOR.CRC_ESCRITORIO";
			statement = connection.prepareStatement(
					createFunction.getGetLastCompanyUpdateSQL() +
					"SELECT "
					+ "  CASE WHEN GEEMPRE.USA_EMPRESA_CENTRALIZADORA = 'S'  "
					+ "    THEN COALESCE(get_last_update(CENT.CODI_EMP, 2, ?), CENT.RAZAO_EMP)  "
					+ "    ELSE COALESCE(get_last_update(GEEMPRE.CODI_EMP, 2, ?), GEEMPRE.RAZAO_EMP)  "
					+ "    END AS RAZAO_CLIENTE, "
					+ "  CASE WHEN GEEMPRE.USA_EMPRESA_CENTRALIZADORA = 'S' "
					+ "    THEN COALESCE(get_last_update(CENT.CODI_EMP, 22, ?), CENT.RLEG_EMP) "
					+ "    ELSE COALESCE(get_last_update(GEEMPRE.CODI_EMP, 22, ?), GEEMPRE.RLEG_EMP)  "
					+ "    END AS RESPONSAVEL_LEG_CLIENTE, "
					+ "  CASE WHEN GEEMPRE.USA_EMPRESA_CENTRALIZADORA = 'S' "
					+ "    THEN COALESCE(get_last_update(CENT.CODI_EMP, 21, ?), CENT.CPF_LEG_EMP) "
					+ "    ELSE COALESCE(get_last_update(GEEMPRE.CODI_EMP, 21, ?), GEEMPRE.CPF_LEG_EMP)  "
					+ "    END AS CPF_LEG_CLIENTE, "
					+ "  CASE WHEN GEEMPRE.USA_EMPRESA_CENTRALIZADORA = 'S' "
					+ "    THEN CENT.CGCE_EMP  "
					+ "    ELSE GEEMPRE.CGCE_EMP "
					+ "    END AS CNPJ_CLIENTE, "
					+ "  COALESCE(get_last_update(GEEMPRE.CODI_EMP, 31, ?), GEEMPRE.CARGO_LEG_EMP) AS CARGO_RESPONSAVEL, "
					+ "  " + crcColumn + " AS CRC_CONTADOR, "
					+ "  TD_MUNICIPIO_CLI.NOME_MUNICIPIO AS CIDADE_CLIENTE "
					+ "  FROM BETHADBA.GEEMPRE AS GEEMPRE  "
					+ "  LEFT OUTER JOIN BETHADBA.GEEMPRE AS CENT  "
					+ "  ON (GEEMPRE.EMPRESA_CENTRALIZADORA = CENT.CODI_EMP)  "
					+ "  LEFT OUTER JOIN BETHADBA.GECONTADOR AS GECONTADOR "
					+ "  ON GEEMPRE.CODI_CON = GECONTADOR.CODI_CON, "
					+ "  LATERAL(SELECT MAX(NOME_MUNICIPIO) AS NOME_MUNICIPIO  "
					+ "    FROM BETHADBA.GEMUNICIPIO AS GEMUNICIPIO  "
					+ "    WHERE GEMUNICIPIO.CODIGO_MUNICIPIO = COALESCE(get_last_update(GEEMPRE.CODI_EMP, 8, ?), GEEMPRE.CODIGO_MUNICIPIO)) AS TD_MUNICIPIO_CLI"
			);
		
			for (int i = 1; i <= 8; i++) {				
				statement.setString(i, lastUpdateDate);
			}
			
			ResultSet rs = statement.executeQuery();
	
			while (rs.next()) {
				responsabilityLetterList.add(
					new ResponsabilityLetter(
						rs.getString("RAZAO_CLIENTE"),
						rs.getString("RESPONSAVEL_LEG_CLIENTE"),
						rs.getString("CPF_LEG_CLIENTE"),
						rs.getString("CNPJ_CLIENTE"),
						rs.getString("CARGO_RESPONSAVEL"),
						rs.getString("CRC_CONTADOR"),
						rs.getString("CIDADE_CLIENTE")
					)
				);
			}
			
			statement.close();
			
			return responsabilityLetterList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return responsabilityLetterList;
	}
	
	
	@Override
	public CompanyResponsabilityLatter getCompany(int id) {
		Connection connection = database.getConnection();
		
		CompanyResponsabilityLatter	 companyResponsabilityLatter = null;
		
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(
					createFunction.getGetLastCompanyUpdateSQL() +
					"SELECT CASE WHEN GEEMPRE.USA_EMPRESA_CENTRALIZADORA = 'S' "
					+ "	THEN  CENT.RAZAO_EMP "
					+ "	ELSE  GEEMPRE.RAZAO_EMP "
					+ "	END AS RAZAO,"
					+ "	GEEMPRE.end_leg_emp AS endereco,"
					+ "	GEEMPRE.nume_emp AS numero,"
					+ "	GEEMPRE.bair_emp AS bairro,"
					+ "	GEEMPRE.codigo_municipio,"
					+ "	GEEMPRE.mun_leg_emp AS municipio,"
					+ "	GEEMPRE.uf_leg_emp AS uf,"
					+ "	GEEMPRE.cepe_emp AS cep"
					+ "	FROM bethadba.geempre AS GEEMPRE"
					+ "	LEFT OUTER JOIN BETHADBA.GEEMPRE AS CENT  "
					+ "	ON (GEEMPRE.EMPRESA_CENTRALIZADORA = CENT.CODI_EMP) "
					+ "where GEEMPRE.codi_emp = "+ id
			);
		
//			for (int i = 1; i <= 8; i++) {				
//				statement.setString(i, lastUpdateDate);
//			}
			
			ResultSet rs = statement.executeQuery();
	
			while (rs.next()) {
				companyResponsabilityLatter = new CompanyResponsabilityLatter(
						rs.getString("RAZAO"),
						rs.getString("endereco"),
						rs.getString("numero"),
						rs.getString("bairro"),
						rs.getString("CODIGO_MUNICIPIO"),
						rs.getString("municipio"),
						rs.getString("uf"),
						rs.getString("cep")
					);
			}
			
			statement.close();
			System.out.println(companyResponsabilityLatter);
			
			return companyResponsabilityLatter;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return companyResponsabilityLatter;
	}
}
