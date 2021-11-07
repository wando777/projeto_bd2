package execute;

import java.sql.SQLException;

import entities.Moeda;

public class Main {

	public static void main(String[] args) {

		Moeda moedaTest = new Moeda();
		moedaTest.setId(1);
		moedaTest.setName("Bitcoin");
		moedaTest.setSupplyMax(21000000.00);
		moedaTest.setCurrentValue(61000.00);

	}

}
