package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectPg.ConnectDataBase;
import entities.Venda;

public class VendaDAO {

	private Connection con;

	public VendaDAO() throws SQLException, ClassNotFoundException {

		con = ConnectDataBase.makeConnection();

	}

	public void addVenda(Venda venda) {
		String sql = "INSERT INTO venda(id, idCorretora, idMoeda) VALUES(?,?,?)";

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, venda.getId());
			preparator.setInt(2, venda.getIdCorretora());
			preparator.setInt(3, venda.getIdMoeda());

			preparator.execute();
			preparator.close();
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void deleteVenda(Venda venda) {
		String sql = "DELETE FROM venda WHERE id = ?";
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, venda.getId());

			preparator.execute();
			preparator.close();
			System.out.println("Venda number: " + venda.getId() + " was successfully deleted from data base");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateVenda(Venda venda, String coloumn) {
		String sql = null;

		try {
			PreparedStatement preparator = null;
			// Update site
			if (coloumn.toLowerCase().equals("idcorretora")) {
				sql = "UPDATE venda SET idCorretora = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setInt(1, venda.getIdCorretora());
			}
			// Update address
			else if (coloumn.toLowerCase().equals("idmoeda")) {
				sql = "UPDATE venda SET idMoeda = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setInt(1, venda.getIdMoeda());
			}
			preparator.setInt(2, venda.getId());

			preparator.execute();
			preparator.close();

			System.out.println("Update was successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Venda> selectAll() {
		String sql = "SELECT * FROM venda";
		List<Venda> list = new ArrayList<Venda>();

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			ResultSet results = preparator.executeQuery();

			while (results.next()) {
				Venda eachVenda = new Venda();
				eachVenda.setId(results.getInt("id"));
				eachVenda.setIdCorretora(results.getInt("idCorretora"));
				eachVenda.setIdMoeda(results.getInt("idMoeda"));

				list.add(eachVenda);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}
