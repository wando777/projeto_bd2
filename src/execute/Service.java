package execute;

import java.util.Scanner;

import entities.Corretora;
import entities.Moeda;
import entities.Venda;

public class Service {
	
	private Boolean mostrarFuncionalidades = true;
	
	public void mostrarFuncionalidades() {
		
		while(mostrarFuncionalidades) {
			Scanner s = new Scanner(System.in);
			System.out.println();
			System.out.println("Digite: ");
			System.out.println("1 para adicionar");
			System.out.println("2 para atualizar ");
			System.out.println("3 para deletar ");
			System.out.println("4 para listar ");
			System.out.println("5 para sair ");
			Integer funcao = Integer.parseInt(s.next());
			s = new Scanner(System.in);
			verificarFuncao(funcao);
		}
	}
	
	private void verificarFuncao(Integer funcao) {
		switch (funcao) {
		case 1:
			adicionarElemento();
			break;
		case 2:
			atualizarElemento();
			break;
		case 3:
			deletarElemento();
			break;
		case 4:
			listarElementos();
			break;
			
		default:
			mostrarFuncionalidades = false;
			break;
		}
	}

	private void listarElementos() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite: ");
		System.out.println("1 para listar Moeda");
		System.out.println("2 para listar Corretora ");
		System.out.println("3 para listar Venda ");
		System.out.println("4 para voltar ");
		Integer elemento = Integer.parseInt(s.next());
		listarElemento(elemento);
		
	}

	private void listarElemento(Integer elemento) {
		switch (elemento) {
		case 1:
			listarMoeda();
			break;
		case 2:
			listarCorretora();
			break;
		case 3:
			listarVenda();
			break;			
		default:
			mostrarFuncionalidades();
			break;
		}
		
	}

	private void listarVenda() {
		VendaDTO vendaDTO = new VendaDTO(0, null, 0, 0);
		vendaDTO.listaVendas();		
	}

	private void listarCorretora() {
		CorretoraDTO corretoraDTO = new CorretoraDTO(0, null, null, null);
		corretoraDTO.listaCorretoras();
	}

	private void listarMoeda() {
		MoedaDTO moedaDTO = new MoedaDTO(0, null, 0L, 0);
		moedaDTO.listaMoedas();
	}

	private void deletarElemento() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite: ");
		System.out.println("1 para deletar Moeda");
		System.out.println("2 para deletar Corretora ");
		System.out.println("3 para deletar Venda ");
		System.out.println("4 para voltar ");
		Integer elemento = Integer.parseInt(s.next());
		verificarRemocaoElemento(elemento);
		
	}

	private void verificarRemocaoElemento(Integer elemento) {
		switch (elemento) {
		case 1:
			removerMoeda();
			break;
		case 2:
			removerCorretora();
			break;
		case 3:
			removerVenda();
			break;			
		default:
			mostrarFuncionalidades();
			break;
		}
		
	}

	private void removerVenda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da venda ");
		Integer id = Integer.parseInt(s.next());
		Venda venda = new Venda();
		venda.setId(id);
		VendaDTO vendaDTO = new VendaDTO(id, null, 0, 0);
		vendaDTO.deleteVenda();
	}

	private void removerCorretora() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da corretora ");
		Integer id = Integer.parseInt(s.next());
		Corretora corretora = new Corretora();
		corretora.setId(id);
		CorretoraDTO corretoraDTO = new CorretoraDTO(id, null, null, null);
		corretoraDTO.deleteCorretora();
	}

	private void removerMoeda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da moeda ");
		Integer id = Integer.parseInt(s.next());
		MoedaDTO moedaDTO = new MoedaDTO(id, null, 0L, 0);
		moedaDTO.deleteMoeda();
		// mostrando null ao dizer o nome
	}

	private void atualizarElemento() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite: ");
		System.out.println("1 para atualizar Moeda");
		System.out.println("2 para atualizar Corretora ");
		System.out.println("3 para atualizar Venda ");
		System.out.println("4 para voltar ");
		Integer elemento = Integer.parseInt(s.next());
		verificarEdicaoElemento(elemento);
		
	}

	private void verificarEdicaoElemento(Integer elemento) {
		switch (elemento) {
		case 1:
			atualizarMoeda();
			break;
		case 2:
			atualizarCorretora();
			break;
		case 3:
			atualizarVenda();
			break;			
		default:
			mostrarFuncionalidades();
			break;
		}
		
	}

	private void atualizarVenda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da venda: ");
		Integer idVenda = Integer.parseInt(s.next());
		System.out.println("Digite 1 para editar o id da corretora: ");
		System.out.println("Digite 2 para editar o id da moeda: ");
		Integer edicao = Integer.valueOf(s.next());
		Integer idCorretora = 0;
		Integer idMoeda = 0;
		String coluna = null;	
		switch (edicao) {
		case 1:
			System.out.println("Digite o id da corretora: ");
			idCorretora = Integer.parseInt(s.next());
			coluna = "idCorretora";
			break;
		case 2:
			System.out.println("Digite o id da moeda: ");
			idMoeda = Integer.parseInt(s.next());
			coluna = "idMoeda";
			break;
		default:
			break;
		}
		VendaDTO vendaDTO = new VendaDTO(idVenda, null, idCorretora, idMoeda);
		vendaDTO.updateVenda(coluna);
	}

	private void atualizarCorretora() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da corretora: ");
		Integer idCorretora = Integer.parseInt(s.next());
		System.out.println("Digite 1 para editar o site da corretora: ");
		System.out.println("Digite 2 para editar o endereço da corretora: ");
		Integer edicao = Integer.valueOf(s.next());
		String siteCorretora = null;
		String enderecoCorretora = null;
		String coluna = null;
		switch (edicao) {
		case 1:
			System.out.println("Digite o site da corretora: ");
			siteCorretora = s.next();
			coluna = "site";
			break;
		case 2:
			System.out.println("Digite o endereço da corretora: ");
			enderecoCorretora = s.next();
			coluna = "address";
			break;
		default:
			break;
		}
		CorretoraDTO corretoraDTO = new CorretoraDTO(idCorretora, null, siteCorretora, enderecoCorretora);
		corretoraDTO.updateCorretora(coluna);
	}

	private void atualizarMoeda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da moeda: ");
		Integer idMoeda = Integer.parseInt(s.next());
		System.out.println("Digite 1 para editar o currentvalue da moeda: ");
		System.out.println("Digite 2 para editar a quantidade da moeda: ");
		Integer edicao = Integer.valueOf(s.next());
		Double currentvalue = (double) 0;
		Long quantidade = 0L;
		String coluna = null;	
		switch (edicao) {
		case 1:
			System.out.println("Digite o currentvalue da corretora: ");
			currentvalue = Double.parseDouble(s.next());
			coluna = "currentvalue";
			break;
		case 2:
			System.out.println("Digite o quantidade da moeda: ");
			quantidade = Long.parseLong(s.next());
			coluna = "quantidade";
			break;
		default:
			break;
		}
		MoedaDTO moedaDTO = new MoedaDTO(idMoeda, null, quantidade, currentvalue);
		moedaDTO.updateMoeda(coluna);
	}

	private void adicionarElemento() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite: ");
		System.out.println("1 para adicionar Moeda");
		System.out.println("2 para adicionar Corretora ");
		System.out.println("3 para adicionar Venda ");
		System.out.println("4 para voltar ");
		Integer elemento = Integer.parseInt(s.next());
		verificarElemento(elemento);
	}

	private void verificarElemento(Integer elemento) {
		switch (elemento) {
		case 1:
			adicionarMoeda();
			break;
		case 2:
			adicionarCorretora();
			break;
		case 3:
			adicionarVenda();
			break;			
		default:
			mostrarFuncionalidades();
			break;
		}
	}

	private void adicionarVenda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da venda: ");
		Integer idVenda = Integer.parseInt(s.next());
		System.out.println("Digite o nome da venda: ");
		String nomeVenda = s.next();
		System.out.println("Digite o id da corretora: ");
		Integer idCorretora = Integer.parseInt(s.next());
		System.out.println("Digite o id da moeda: ");
		Integer idMoeda = Integer.parseInt(s.next());
		VendaDTO vendaDto = new VendaDTO(idVenda, nomeVenda, idCorretora, idMoeda);
		vendaDto.addVenda();
	}

	private void adicionarCorretora() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da corretora: ");
		Integer idCorretora = Integer.parseInt(s.next());
		System.out.println("Digite o nome da corretora: ");
		String nomeCorretora = s.next();
		System.out.println("Digite o site da corretora: ");
		String siteCorretora = s.next();
		System.out.println("Digite o endereço da corretora: ");
		String enderecoCorretora = s.next();
		CorretoraDTO corretoraDTO = new CorretoraDTO(idCorretora, nomeCorretora, siteCorretora, enderecoCorretora);
		corretoraDTO.addCorretora();
	}

	private void adicionarMoeda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da moeda: ");
		Integer idMoeda = Integer.parseInt(s.next());
		System.out.println("Digite o nome da moeda: ");
		String nomeMoeda = s.next();
		System.out.println("Digite quantidade da moeda: ");
		Long quantidade = Long.parseLong(s.next());
		System.out.println("Digite o valor da moeda: ");
		Integer valorMoeda = Integer.parseInt(s.next());
		MoedaDTO moedaDTO = new MoedaDTO(idMoeda, nomeMoeda, quantidade, valorMoeda);
		moedaDTO.addMoeda();
	}
}
