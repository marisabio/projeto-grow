package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		con = DriverManager.getConnection(url, "rm96881", "250998");
		System.out.println("Abriu a conexão!");
		con.close();
		System.out.println("Fechou conexão.");
	}
}
