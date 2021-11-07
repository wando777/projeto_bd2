package execute;

import java.sql.SQLException;

import DAO.MoedaDAO;
import entities.Moeda;

public class Main {

	public static void main(String[] args) {

		Moeda moedaTest = new Moeda();
		moedaTest.setId(1);
		moedaTest.setName("Bitcoin");
		moedaTest.setSupplyMax(21000000.00);
		moedaTest.setCurrentValue(61500.00);

		MoedaDAO moedaDAO = null;

		try {
			moedaDAO = new MoedaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		/** Chamadas de testes dos métodos DAO **/
		moedaDAO.addMoeda(moedaTest);
//		moedaDAO.updateMoeda(moedaTest, "currentvalue");
//		moedaDAO.deleteMoeda(moedaTest);


	}

}
