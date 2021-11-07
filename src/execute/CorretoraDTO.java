package execute;

import java.sql.SQLException;
import java.util.List;

import DAO.CorretoraDAO;
import entities.Corretora;

public class CorretoraDTO {

	Corretora corretoraTest = new Corretora();
	CorretoraDAO corretoraDAO = null;

	public CorretoraDTO(int id, String name, String site, String address) {
		corretoraTest.setId(id);
		corretoraTest.setName(name);
		corretoraTest.setSite(site);
		corretoraTest.setAddress(address);
	}

	public void addCorretora(Corretora corretoraTest) {

		try {
			corretoraDAO = new CorretoraDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		corretoraDAO.addCorretora(corretoraTest);
	}

	public void deleteCorretora(Corretora corretoraTest) {

		try {
			corretoraDAO = new CorretoraDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		corretoraDAO.deleteCorretora(corretoraTest);
	}

	public void listaCorretoras(Corretora corretoraTest) {

		try {
			corretoraDAO = new CorretoraDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Corretora> list = corretoraDAO.selectAll();
		for (Corretora corretora : list) {
			System.out.println(corretora);
		}
	}

}
