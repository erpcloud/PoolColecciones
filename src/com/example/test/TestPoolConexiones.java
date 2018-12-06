package com.example.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.pool.PoolConexionesMySQL;
import com.example.pool.PoolConexionesOracle;

public class TestPoolConexiones {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Pool de conexiones MySQL
		try {
			conn = PoolConexionesMySQL.getConexion();
			System.out.println("Utilizamos el pool de conexiones de MySQL");
			stmt = conn.prepareStatement("SELECT * FROM personas");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				System.out.print(" " + rs.getInt(1));
				System.out.print(" " + rs.getString(2));
				System.out.println(" " + rs.getString(3));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*// Pool de conexiones Oracle
		try {
			conn = PoolConexionesOracle.getConexion();
			
			System.out.println("Utilizamos el pool de conexiones de Oracle");
			
			stmt = conn.prepareStatement("SELECT * FROM employees WHERE employee_id in(100, 101, 102)");
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				System.out.print(" " + rs.getInt(1));
				System.out.print(" " + rs.getString(2));
				System.out.println(" " + rs.getString(3));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
}

// Cambiamos el mensaje comentado nuevamente otro intento
