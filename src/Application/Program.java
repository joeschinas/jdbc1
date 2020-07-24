package Application;

import java.sql.Connection;

import db.Db;

public class Program {

	public static void main(String[] args) {
		System.out.println("teste");
		Connection conn = Db.getConnection();
		Db.closeConnection();
		System.out.println("Sucesso");

	}

}
