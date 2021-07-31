package com.api.crm.database;

import java.sql.Connection;

public interface IDatabase {
	public Connection getConnection();
	public boolean hasConnection();
}
