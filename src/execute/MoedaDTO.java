package execute;

import java.sql.SQLException;
import java.util.List;

import DAO.MoedaDAO;
import entities.Moeda;

public class MoedaDTO {

	Moeda moedaTest = new Moeda();
	MoedaDAO moedaDAO = null;

	public MoedaDTO(int id, String name, Long quantidade, double currentValue) {
		moedaTest.setId(id);
		moedaTest.setName(name);
		moedaTest.setQuantidade(quantidade);
		moedaTest.setCurrentValue(currentValue);
	}

	public void addMoeda() {

		createMoedaDAO();

		moedaDAO.addMoeda(moedaTest);
	}

	private void createMoedaDAO() {
		try {
			moedaDAO = new MoedaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteMoeda() {

		createMoedaDAO();

		moedaDAO.deleteMoeda(moedaTest);
	}

	public void listaMoedas() {

		createMoedaDAO();

		List<Moeda> list = moedaDAO.selectAll();
		for (Moeda moeda : list) {
			System.out.println(moeda);
		}
	}
	
	public void updateMoeda(String colum) {
		
		createMoedaDAO();
		moedaDAO.updateMoeda(moedaTest, colum);
	}

}
