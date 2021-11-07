package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectPg.ConnectDataBase;
import entities.Moeda;

public class MoedaDAO {

	private Connection con;

	public MoedaDAO() throws SQLException, ClassNotFoundException {

		con = ConnectDataBase.makeConnection();

	}

	public void addMoeda(Moeda moeda) {
		String sql = "INSERT INTO moeda(id, name, supplyMax, currentValue) VALUES(?,?,?,?)";

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, moeda.getId());
			preparator.setString(2, moeda.getName());
			preparator.setDouble(3, moeda.getSupplyMax());
			preparator.setDouble(4, moeda.getCurrentValue());

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
