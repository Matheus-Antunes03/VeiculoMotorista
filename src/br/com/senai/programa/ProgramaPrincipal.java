package br.com.senai.programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.motorista.Motorista;
import br.com.senai.motorista.MotoristaController;
import br.com.senai.veiculo.Veiculo;
import br.com.senai.veiculo.VeiculoController;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
	
	List<Veiculo> veiculos = new ArrayList<>();
	List<Motorista> motoristas = new ArrayList<>();
	
	VeiculoController veiculoController = new VeiculoController();
	MotoristaController motoristaController = new MotoristaController();
	
	Scanner tec = new Scanner(System.in);
	boolean sair = false;
	
	do {
		System.out.println("--- MENU ---");
		System.out.println("1) Registro de veículos");
		System.out.println("2) Registro de Motoristas");
		System.out.println("3) Sair");
		System.out.print("> ");
		int opcao = tec.nextInt();
		
		switch (opcao) {
		case 1:
			veiculoController.menu1(veiculos, motoristas);
			break;
			
		case 2:
			motoristaController.menu2(motoristas, veiculos);
			break;
			
		case 3:
			sair = true;
			break;
			
		default:
			System.out.println("Opção Inválida!");
			break;
		}
		
	} while (!sair);

	System.out.println("Sistema encerrado.");
}
}