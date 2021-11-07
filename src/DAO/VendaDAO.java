package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectPg.ConnectDataBase;
import entities.Venda;

public class VendaDAO {

	private Connection con;

	public VendaDAO() throws SQLException, ClassNotFoundException {

		con = ConnectDataBase.makeConnection();

	}

	public void addVenda(Venda venda) {
		String sql = "INSERT INTO venda(id, name, site, address) VALUES(?,?,?,?)";

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

}
