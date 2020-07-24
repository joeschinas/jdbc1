package Application;

import java.sql.Connection;

import db.Db;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("teste");
		Connection conn = Db.getConnection();
		Db.closeConnection();
		
		/*olha proximo projeto no github,
		terá exemplos de como acessar os dados do banco */
	}

}
