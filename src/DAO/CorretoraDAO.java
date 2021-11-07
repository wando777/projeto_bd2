package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public void deleteCorretora(Corretora corretora) {
		String sql = "DELETE FROM corretora WHERE id = ?";
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, corretora.getId());

			preparator.execute();
			preparator.close();
			System.out.println(corretora.getName() + " was successfully deleted from data base");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateCorretora(Corretora corretora, String coloumn) {
		String sql = null;

		try {
			PreparedStatement preparator = null;
			// Update site
			if (coloumn.toLowerCase().equals("site")) {
				sql = "UPDATE corretora SET site = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setString(1, corretora.getSite());
			}
			// Update address
			else if (coloumn.toLowerCase().equals("address")) {
				sql = "UPDATE corretora SET address = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setString(1, corretora.getAddress());
			}
			preparator.setInt(2, corretora.getId());

			preparator.execute();
			preparator.close();

			System.out.println("Update was successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Corretora> selectAll() {
		String sql = "SELECT * FROM corretora";
		List<Corretora> list = new ArrayList<Corretora>();

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			ResultSet results = preparator.executeQuery();

			while (results.next()) {
				Corretora eachCorretora = new Corretora();
				eachCorretora.setId(results.getInt("id"));
				eachCorretora.setName(results.getString("name"));
				eachCorretora.setSite(results.getString("site"));
				eachCorretora.setAddress(results.getString("address"));

				list.add(eachCorretora);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
