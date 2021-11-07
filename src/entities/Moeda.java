package entities;

public class Moeda {

	private int id;
	private String name;
	private Long supplyMax;
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

	public long getSupplyMax() {
		return supplyMax;
	}

	public void setSupplyMax(long i) {
		this.supplyMax = i;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	@Override
	public String toString() {
		return "id: " + id + " Name: " + name + " Supply Max: $" + supplyMax + " Current Value: $" + currentValue;
	}
	
}
