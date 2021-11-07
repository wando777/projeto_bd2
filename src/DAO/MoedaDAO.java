package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			preparator.setLong(3, moeda.getSupplyMax());
			preparator.setDouble(4, moeda.getCurrentValue());

			preparator.execute();
			preparator.close();
			System.out.println(moeda.getName() + " was successfully added");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateMoeda(Moeda moeda, String coloumn) {
		String sql = null;

		try {
			PreparedStatement preparator = null;
			// Atualizar currentValue
			if (coloumn.toLowerCase().equals("currentvalue")) {
				sql = "UPDATE moeda SET currentValue = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setDouble(1, moeda.getCurrentValue());
			}
			// Atualizar supplyMax
			else if (coloumn.toLowerCase().equals("supplymax")) {
				sql = "UPDATE moeda SET supplyMax = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setLong(1, moeda.getSupplyMax());
			}
			preparator.setInt(2, moeda.getId());

			preparator.execute();
			preparator.close();

			System.out.println("Update was successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteMoeda(Moeda moeda) {
		String sql = "DELETE FROM moeda WHERE id = ?";
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, moeda.getId());

			preparator.execute();
			preparator.close();
			System.out.println(moeda.getName() + " was successfully deleted from data base");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Moeda> selectAll() {
		String sql = "SELECT * FROM moeda";
		List<Moeda> list = new ArrayList<Moeda>();

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			ResultSet results = preparator.executeQuery();

			while (results.next()) {
				Moeda eachMoeda = new Moeda();
				eachMoeda.setId(results.getInt("id"));
				eachMoeda.setName(results.getString("name"));
				eachMoeda.setCurrentValue(results.getDouble("currentValue"));
				eachMoeda.setSupplyMax(results.getLong("supplyMax"));

				list.add(eachMoeda);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
