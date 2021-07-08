package br.com.senai.motorista;

import java.util.List;
import java.util.Scanner;

import br.com.senai.veiculo.Veiculo;
import br.com.senai.veiculo.VeiculoController;

public class MotoristaController {
	
	VeiculoController veiculoController = new VeiculoController();
	
	private Scanner tec;
	
	public MotoristaController() {
		tec = new Scanner(System.in);
	}
	
	public int leopcao() {
		System.out.print("> ");
		return tec.nextInt();
	}
	
	public Motorista cadastrarMotorista(List<Motorista> motoristas, List<Veiculo> veiculos) {
		if (veiculos.isEmpty()) {
			System.out.println("Impossível cadastrar um motorista sem carros cadastrados.");
			return null;
		}
		Motorista motorista = new Motorista();
		Veiculo veiculo = new Veiculo();
		
		int idVeiculo = 1;
		
		veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
		veiculo.setAno(veiculos.get(idVeiculo).getAno());
		veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
		veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
		veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
		
		System.out.println("--- CADASTRAR MOTORISTA ---");
		System.out.print("Informe o nome do motorista: ");
		motorista.setNome(tec.next());
		
		System.out.print("Informe a idade do motorista: ");
		motorista.setIdade(tec.nextInt());
		
		System.out.print("Informe a categoria da habilitação do motorista");
		motorista.setCategoriaHabilitacao(tec.next());
		
		veiculoController.listarVeiculos(veiculos);
		System.out.print("Informe o id do veículo do motorista: ");
		motorista.setVeiculo(veiculo);
		
		return motorista;
	}
	
	public List<Motorista> listarMotoristas(List<Motorista> motoristas) {
		
		if (motoristas.isEmpty()) {
			System.out.println("Nenhum motorista cadastrado.");
			return null;
		}
		
		System.out.println("--- MOTORISTAS CADASTRADOS ---");
		
		System.out.printf("| %2s | %10s | %5s | %21s | %7s |\n",
				"Id", "Nome", "Idade", "Categoria Habilitação", "Veículo");
		
		for (int i = 0; i < motoristas.size(); i++) {
			System.out.printf("| %2s | %10s | %5d | %21s | %7d |\n",
					i + 1,
					motoristas.get(i).getNome(),
					motoristas.get(i).getIdade(),
					motoristas.get(i).getCategoriaHabilitacao(),
					motoristas.get(i).getVeiculo());
		}
		
		return motoristas;
	}
	
	public List<Motorista> editarMotorista(List<Motorista> motoristas, List<Veiculo> veiculos) {
		
		Motorista motorista = new Motorista();
		Veiculo veiculo = new Veiculo();
		
		listarMotoristas(motoristas);
		
		if (motoristas.isEmpty()) {
			return null;
		}
		System.out.println("--- EDITAR MOTORISTA ---");
		System.out.print("Informe o Id do motorista para ser editado: ");
		int idMotorista = tec.nextInt() - 1;
		
		System.out.println("1) Nome");
		System.out.println("2) Idade");
		System.out.println("3) Categoria da Habilitação");
		System.out.println("4) Veículo");
		System.out.print("Informe o campo que deseja alterar: ");
		int opcao = tec.nextInt();
		
		switch (opcao) {
		
		case 1:
			System.out.println("--- EDITAR O NOME ---");
			System.out.print("Informe o novo nome: ");
			motorista.setNome(tec.next());
			
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			
			motoristas.set(idMotorista, motorista);
			break;
			
		case 2:
			System.out.println("--- EDITAR A IDADE ---");
			System.out.print("Informe a nova idade: ");
			motorista.setIdade(tec.nextInt());
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			
			motoristas.set(idMotorista, motorista);
			break;
			
		case 3:
			System.out.println("--- EDITAR A CATEGORIA DA HABILITAÇÃO ---");
			System.out.print("Informe a nova categoria: ");
			motorista.setCategoriaHabilitacao(tec.next());
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			
			motoristas.set(idMotorista, motorista);
			break;
			
		case 4:
			System.out.println("--- EDITAR O VEÍCULO ---");
			veiculoController.listarVeiculos(veiculos);
			System.out.println("Informe o novo Id do veículo");
			motorista.setVeiculo(veiculo);
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			
			motoristas.set(idMotorista, motorista);
			break;
			
		default:
			System.out.println("Opção inválida!");
			break;
		}
		
		return motoristas;
	}
	
	public void excluirMotorista(List<Motorista> motoristas) {
		
		listarMotoristas(motoristas);
		
		if (motoristas.isEmpty()) {
			return;
		}
		
		System.out.println("--- EXCLUIR MOTORISTA ---");
		
		System.out.print("Informe o id do motorista para ser excluído: ");
		int idMotorista = tec.nextInt() - 1;
		
		if (motoristas.size() <= idMotorista) {
			System.out.println("Motorista não cadastrado.");
		}
		
		motoristas.remove(idMotorista);
		
	}
	
	public void menu2(List<Motorista> motoristas, List<Veiculo> veiculos) {
		boolean sair = false;
		
		do {
			System.out.println("--- MENU ---");
			System.out.println("1) Cadastrar motorista");
			System.out.println("2) Listar motoristas");
			System.out.println("3) Editar motorista");
			System.out.println("4) Excluir motorista");
			System.out.println("5) Voltar");
			
			int opcao = leopcao();
			switch (opcao) {
			case 1:
				motoristas.add(cadastrarMotorista(motoristas, veiculos));
				break;
				
			case 2:
				listarMotoristas(motoristas);
				break;
				
			case 3:
				editarMotorista(motoristas, veiculos);
				break;
				
			case 4:
				excluirMotorista(motoristas);
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
