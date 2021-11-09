package entities;

public class Moeda {

	private int id;
	private String name;
	private double currentValue;
	private Long quantidade;

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

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

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	@Override
	public String toString() {
		return "id: " + id + " Name: " + name + " Current Value: $" + currentValue;
	}
	
}
