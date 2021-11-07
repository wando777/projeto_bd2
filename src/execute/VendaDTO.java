package execute;

import java.sql.SQLException;
import java.util.List;

import DAO.VendaDAO;
import entities.Venda;

public class VendaDTO {

	Venda vendaTest = new Venda();
	VendaDAO vendaDAO = null;

	public VendaDTO(int id, String name, int idCorretora, int idMoeda) {
		vendaTest.setId(id);
		vendaTest.setIdCorretora(idCorretora);
		vendaTest.setIdMoeda(idMoeda);
	}

	public void addVenda(Venda vendaTest) {

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		vendaDAO.addVenda(vendaTest);
	}

	public void deleteVenda(Venda vendaTest) {

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		vendaDAO.deleteVenda(vendaTest);
	}

	public void listaVendas(Venda vendaTest) {

		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Venda> list = vendaDAO.selectAll();
		for (Venda venda : list) {
			System.out.println(venda);
		}
	}

}
