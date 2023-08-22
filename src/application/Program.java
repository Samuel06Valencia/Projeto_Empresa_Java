package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionarios;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Entrada da quantidade de funcionários a serem preenchidas.
		System.out.println("---------------------------------------");
		System.out.println("Quantos funcionários deseja registrar? ");
		int n = sc.nextInt();
		System.out.println("---------------------------------------");
		
		//Lista baseada na classe Funcionários e seus paramêtros.
		List<Funcionarios> list = new ArrayList<>();
		
		
		//estrutura de repetição,que percorre as informações dos funcionários.
		for(int i = 0; i < n; i++) {
			
			System.out.println("Employee #"+ i+1+":");
			System.out.print("ID: ");
			int id = sc.nextInt();
			
			//Validação de verificação,se o id já existe.
			while(hasId(list, id)) {
				System.out.println("------------------------------------");
				System.out.println("Esse Id já existe! Tente novamente: ");
				System.out.println("------------------------------------");
				id = sc.nextInt();
			}
			
			
			//Entrada de informações.
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			//Instanciação do Construtor.
			Funcionarios func = new Funcionarios(name,id,salary);
			//Adiciona paramêtros do Construtor na Lista.
			list.add(func);
			
			System.out.println("----------------------------------------");
			//fim do for
		}
			//Continuação do sistema...
			System.out.println("--------------------------------------");
			System.out.println("Entre com ID do funcionário desejado: ");
			System.out.println("--------------------------------------");
			int position = sc.nextInt();
			
			//Busca o ID da lista e compara com o digitado.
			Funcionarios emp = list.stream().filter(x -> x.getId() == position).findFirst().orElse(null);
			
			//se o id não bater com algum da lista,retorne null.
			if(emp == null) {
				System.out.println("-----------------------");
				System.out.println("This id does not exist!");
				System.out.println("-----------------------");
			}
			//Caso o id exista,continue com a operação:
			else {
				//Entra com a porcentagem desejada e busca o método de incremento do salário existente na classe.
				System.out.println("----------------------");
				System.out.println("Enter the percentage: ");
				System.out.println("----------------------");
				Double percent = sc.nextDouble();
				emp.increaseSalary(percent);
			}
			//Exibição da Lista de funcionários,com for percorrendo a lista com o método toString() sobreescrito.
			System.out.println("-----------------------");
			System.out.println("Lista de Funcionários: ");
			System.out.println("-----------------------");
			for(Funcionarios func : list) {
				System.out.println(func);
			}
			
	}
	//método estático para verificação de id,usado na validação do id com a estrutura while().
	public static boolean hasId(List<Funcionarios> list, int id) {
		Funcionarios emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
