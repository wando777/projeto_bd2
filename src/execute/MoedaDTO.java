package execute;

import java.sql.SQLException;
import java.util.List;

import DAO.MoedaDAO;
import entities.Moeda;

public class MoedaDTO {

	Moeda moedaTest = new Moeda();
	MoedaDAO moedaDAO = null;

	public MoedaDTO(int id, String name, long supplyMax, double currentValue) {
		moedaTest.setId(id);
		moedaTest.setName(name);
		moedaTest.setSupplyMax(supplyMax);
		moedaTest.setCurrentValue(currentValue);
	}

	public void addMoeda() {

		try {
			moedaDAO = new MoedaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		moedaDAO.addMoeda(moedaTest);
	}

	public void deleteMoeda() {

		try {
			moedaDAO = new MoedaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		moedaDAO.deleteMoeda(moedaTest);
	}

	public void listaMoedas() {

		try {
			moedaDAO = new MoedaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Moeda> list = moedaDAO.selectAll();
		for (Moeda moeda : list) {
			System.out.println(moeda);
		}
	}

}
