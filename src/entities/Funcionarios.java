package entities;

public class Funcionarios {
	//Atributos.
	private String name;
	private Integer id;
	private Double salary;
	
	//Construtor padrão.
	public Funcionarios() {}

	//Construtor com paramêtros e atributos.
	public Funcionarios(String name, Integer id, Double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	//Métdos de encapsulamento de dados,Getters e Setters:
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	//Método de incremento de porcentagem no salário.
	public Double increaseSalary(Double porcent) {
		return salary += salary * porcent / 100;
	}
	
	
	//Método toString() sobreescrito.
	@Override
	public String toString() {
		return id+", "+name+", "+String.format("%.3f", salary);
	}
	
	
}
