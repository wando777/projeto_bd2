package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectPg.ConnectDataBase;
import entities.Corretora;

public class CorretoraDAO {

	private Connection con;

	public CorretoraDAO() throws SQLException, ClassNotFoundException {

		con = ConnectDataBase.makeConnection();

	}

	public void addCorretora(Corretora corretora) {
		String sql = "INSERT INTO corretora(id, name, site, address) VALUES(?,?,?,?)";

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, corretora.getId());
			preparator.setString(2, corretora.getName());
			preparator.setString(3, corretora.getSite());
			preparator.setString(4, corretora.getAddress());

			preparator.execute();
			preparator.close();
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
