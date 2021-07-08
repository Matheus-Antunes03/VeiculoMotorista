package br.com.senai.veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.motorista.Motorista;
import br.com.senai.motorista.MotoristaController;

public class VeiculoController {
	
	private Scanner tec;
	
	
	public VeiculoController() {
		tec = new Scanner(System.in);
	}
	
	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public Veiculo cadastrarVeiculo(List<Veiculo> veiculos) {
		
		Veiculo veiculo = new Veiculo();
		
		System.out.println("--- CADASTRAR VEÍCULO ---");
		System.out.print("Informe o modelo do veículo: ");
		veiculo.setModelo(tec.next());
		
		System.out.print("Informe o ano do veículo: ");
		veiculo.setAno(tec.nextInt());
		
		System.out.print("Informe o tipo de combustível do veículo: ");
		veiculo.setTipoCombustivel(tec.next());
		
		System.out.print("Informe a placa do veículo: ");
		veiculo.setPlaca(tec.next());
		
		System.out.print("Informe a marca do veículo: ");
		veiculo.setMarca(tec.next());
		
		return veiculo;
	}
	
	public List<Veiculo> listarVeiculos(List<Veiculo> veiculos) {
		
		if (veiculos.isEmpty()) {
			System.out.println("Não existem veículos cadastrados.");
			return null;
		}
		
		System.out.println("--- VEÍCULOS CADASTRADOS ---");
		System.out.printf("| %2s | %10s | %4s | %11s | %8s | %10s |\n",
				"Id", "Modelo", "Ano", "Combustível", "Placa", "Marca");
		
		for (int i = 0; i < veiculos.size(); i++) {
			System.out.printf("| %2s | %10s | %4d | %11s | %8s | %10s |\n",
					i + 1,
					veiculos.get(i).getModelo(),
					veiculos.get(i).getAno(),
					veiculos.get(i).getTipoCombustivel(),
					veiculos.get(i).getPlaca(),
					veiculos.get(i).getMarca());
		}
		
		return veiculos;
	}
	
	public List<Veiculo> editarVeiculo(List<Veiculo> veiculos) {
		
		Veiculo veiculo = new Veiculo();
		
		listarVeiculos(veiculos);
		
		if (veiculos.isEmpty()) {
			return null;
		}
		System.out.println("--- EDITAR VEÍCULO ---");
		System.out.print("Informe o Id do veículo: ");
		int idVeiculo = tec.nextInt() - 1;
		System.out.println("1) Modelo");
		System.out.println("2) Ano");
		System.out.println("3) Combustível");
		System.out.println("4) Placa");
		System.out.println("5) Marca");
		System.out.print("Informe o campo que deseja alterar: ");
		int opcao = tec.nextInt();
		
		switch (opcao) {
		
		case 1:
			System.out.println("--- EDITAR O MODELO DO CARRO ---");
			System.out.print("Informe o novo modelo do carro: ");
			veiculo.setModelo(tec.next());
			
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			
			veiculos.set(idVeiculo, veiculo);
			break;
			
		case 2:
			System.out.println("--- EDITAR O ANO ---");
			System.out.print("Informe o novo ano do carro: ");
			veiculo.setAno(tec.nextInt());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			
			veiculos.set(idVeiculo, veiculo);
			break;
			
		case 3:
			System.out.println("--- EDITAR O COMBUSTÍVEL ---");
			System.out.print("Informe o novo tipo de combustível do carro: ");
			veiculo.setTipoCombustivel(tec.next());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			
			veiculos.set(idVeiculo, veiculo);
			break;
			
		case 4:
			System.out.println("--- EDITAR A PLACA DO VEICULO ---");
			System.out.print("Informe a nova placa do carro:");
			veiculo.setPlaca(tec.next());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			
			veiculos.set(idVeiculo, veiculo);
			break;
			
		case 5:
			System.out.println("--- EDITAR A MARCA ---");
			System.out.print("Informe a nova marca do carro");
			veiculo.setMarca(tec.next());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			
			veiculos.set(idVeiculo, veiculo);
			break;
			
		default:
			System.out.println("Opção inválida!");
			break;
		}
		return veiculos;
	}
	
	public void excluirVeiculo(List<Veiculo> veiculos, List<Motorista> motoristas) {
		
		listarVeiculos(veiculos);
		
		if(veiculos.isEmpty()) {
			return;
		}
		
		System.out.println("--- EXCLUIR VEICULO ---");
		System.out.print("Informe o Id do veículo que deseja excluir: ");
		int idVeiculo = tec.nextInt() - 1;
		
		for (int i = 0; motoristas.get(idVeiculo).getVeiculo() == veiculos.get(idVeiculo); i++) {
			System.out.println("Não é possível excluir um veículo atribuido a um motorista.");
			return;
		}
		
		if (veiculos.size() <= idVeiculo) {
			System.out.println("Veículo não cadastrado.");
			return;
		}
		
		veiculos.remove(idVeiculo);
		
	}
	
	public void menu1(List<Veiculo> veiculos, List<Motorista> motoristas) {
		boolean sair = false;
		
		do {
			System.out.println("--- MENU ---");
			System.out.println("1) Cadastrar veículo");
			System.out.println("2) Listar veículos");
			System.out.println("3) Editar veículo");
			System.out.println("4) Excluir veículo");
			System.out.println("5) Voltar");
			
			int opcao = leopcao();
			switch (opcao) {
			case 1:
				veiculos.add(cadastrarVeiculo(veiculos));
				break;
				
			case 2:
				listarVeiculos(veiculos);
				break;
				
			case 3:
				editarVeiculo(veiculos);
				break;
				
			case 4:
				excluirVeiculo(veiculos, motoristas);
				break;
				
			case 5:
				sair = true;
				break;

			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (!sair);
	}
		
}
