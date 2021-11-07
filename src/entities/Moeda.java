package entities;

public class Moeda {

	private int id;
	private String name;
	private double supplyMax;
	private double currentValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSupplyMax() {
		return supplyMax;
	}

	public void setSupplyMax(double supplyMax) {
		this.supplyMax = supplyMax;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

}
