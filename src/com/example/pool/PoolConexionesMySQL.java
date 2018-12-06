package com.example.pool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConexionesMySQL {
	
	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("sasa");
		ds.setUrl("jdbc:mysql://192.168.99.100:3306/sga?useSSL=false");
		
		// Definimos el tamaño del pool de conexiones
		ds.setInitialSize(5); // 5 conexiones iniciales
		
		return ds;
	}
	
	public static Connection getConexion() throws SQLException {
		return getDataSource().getConnection();
	}
}
