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

	public void addVenda() {

		createVendaDAO();

		vendaDAO.addVenda(vendaTest);
	}

	public void deleteVenda() {

		createVendaDAO();

		vendaDAO.deleteVenda(vendaTest);
	}

	public void listaVendas() {

		createVendaDAO();

		List<Venda> list = vendaDAO.selectAll();
		for (Venda venda : list) {
			System.out.println(venda);
		}
	}

	private void createVendaDAO() {
		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void updateVenda(String colum) {
		
		createVendaDAO();
		vendaDAO.updateVenda(vendaTest, colum);
		
	}

}
