package execute;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DAO.MoedaDAO;
import entities.Moeda;

public class Main {

	public static void main(String[] args) {

//		Moeda moedaTest = new Moeda();
//		moedaTest.setId(2);
//		moedaTest.setName("Cardano");
//		moedaTest.setSupplyMax(100000000);
//		moedaTest.setCurrentValue(2.05);
//
//		MoedaDAO moedaDAO = null;
//
//		try {
//			moedaDAO = new MoedaDAO();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

		/** Chamadas de testes dos métodos DAO **/
//		moedaDAO.addMoeda(moedaTest);
//		moedaDAO.updateMoeda(moedaTest, "currentvalue");
//		moedaDAO.deleteMoeda(moedaTest);
//		List<Moeda> list = moedaDAO.selectAll();
//		for (Moeda moeda : list) {
//			System.out.println(moeda);
//		}

		/* Usando as classes DTO */
//		MoedaDTO moeda = new MoedaDTO(1, "Bitcoin", 100000000, 2.5);
//		moeda.addMoeda();
//		moeda.listaMoedas();
//		moeda.deleteMoeda();
//		moeda.listaMoedas();
		
		Service service = new Service();		
		service.mostrarFuncionalidades();
	}
	
	

}
