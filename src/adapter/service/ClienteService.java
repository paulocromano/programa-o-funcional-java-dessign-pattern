package adapter.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import adapter.enums.TipoPessoa;
import adapter.model.Cliente;
import adapter.repository.DbAdapter;
import adapter.repository.Firebase;
import adapter.repository.FirebaseAdapter;
import util.ExecuteService;

public class ClienteService implements ExecuteService {
	
	private List<Cliente> clientes = new ArrayList<>();
	
	public ClienteService() {
		DbAdapter<Cliente> adapter = new FirebaseAdapter(new Firebase());
		this.clientes = adapter.buscar();
	}

	@Override
	public void execute() {
		//this.agruparClientesPeloTipoPessoa();
		//this.agruparClientesPeloTipoPessoaNascidosNoAno(1996);
		this.totalClientesNascidosEm(1996, Month.FEBRUARY);
		//this.agruparClientesPeloAnoETipoPessoa();
		//this.agruparClientesPelosQuePossuemDeficiencia();
		//this.buscarNomesDeClientesJuridicos();
	}
	
	public void agruparClientesPeloTipoPessoa() {
		Map<TipoPessoa, List<Cliente>> clientes = this.clientes.stream()
				.collect(Collectors.groupingBy(Cliente::getTipoPessoa));
		
		System.out.println(clientes);
	}

	public void agruparClientesPeloTipoPessoaNascidosNoAno(int ano) {
		Map<TipoPessoa, List<Cliente>> clientesAgrudadosPeloTipoPessoa = this.clientes.stream()
				.collect(Collectors.filtering(cliente -> cliente.getDataNascimento().getYear() == ano,
						Collectors.groupingBy(cliente -> cliente.getTipoPessoa(), Collectors.toList())));

		System.out.println(clientesAgrudadosPeloTipoPessoa);
	}
	
//	public void agruparClientesPeloTipoPessoaNascidosNoAno(int ano) {
//		Map<TipoPessoa, List<Cliente>> clientesAgrudadosPeloTipoPessoa = new HashMap<>();
//		List<Cliente> clientesFiltradosPeloAno = new ArrayList<>();
//		
//		for (Cliente cliente : this.clientes) {
//			if (cliente.getDataNascimento().getYear() == ano) {
//				clientesFiltradosPeloAno.add(cliente);
//			}
//		}
//		
//		for (Cliente cliente : clientesFiltradosPeloAno) {
//			TipoPessoa tipoPessoa = cliente.getTipoPessoa();
//			List<Cliente> clientes = clientesAgrudadosPeloTipoPessoa.containsKey(tipoPessoa) 
//					? clientesAgrudadosPeloTipoPessoa.get(tipoPessoa) : new ArrayList<>();
//			
//			clientes.add(cliente);
//			clientesAgrudadosPeloTipoPessoa.put(tipoPessoa, clientes);
//		}
//
//		System.out.println(clientesAgrudadosPeloTipoPessoa);
//	}
	
	public void totalClientesNascidosEm(int ano, Month mes) {
		Long total = this.clientes.stream().collect(Collectors.filtering(
				cliente -> cliente.getDataNascimento().getYear() == ano && cliente.getDataNascimento().getMonth().equals(mes), 
					Collectors.counting()));
		
		System.out.println("Total de clientes nascidos em: " + ano + "/" + mes + ": " + total);
	}
	
//	public void totalClientesNascidosEm(int ano, Month mes) {
//		long total = 0;
//		
//		for (Cliente cliente : this.clientes) {
//			if (cliente.getDataNascimento().getYear() == ano 
//					&& cliente.getDataNascimento().getMonth().equals(mes)) {
//				total++;
//			}
//		}
//		
//		System.out.println("Total de clientes nascidos em: " + ano + "/" + mes + ": " + total);
//	}
	
	
	public void agruparClientesPeloAnoETipoPessoa() {
		System.out.println("Clientes agrupados pelo ano de nascimento e pelo tipo de pessoa");
		
		Map<Integer, Map<TipoPessoa, List<Cliente>>> clientes = this.clientes.stream()
				.collect(Collectors.groupingBy(cliente -> cliente.getDataNascimento().getYear(), 
						Collectors.groupingBy(Cliente::getTipoPessoa, HashMap::new, Collectors.toList())));
		
		System.out.println(clientes);
	}
	
	public void agruparClientesPelosQuePossuemDeficiencia() {
		System.out.println("Clientes agrupados pelos que têm ou não deficiência");
		
		Map<Boolean, List<Cliente>> clientes = this.clientes.stream()
				.collect(Collectors.partitioningBy(Cliente::getIsDeficiente));
		
		System.out.println(clientes);
	}
	
	public void buscarNomesDeClientesJuridicos() {
		String nomes = this.clientes.stream().filter(cliente -> cliente.getTipoPessoa().equals(TipoPessoa.JURIDICA))
				.map(Cliente::getNome).collect(Collectors.joining(", "));
		
		System.out.println("Nomes dos Clientes jurídicos: " + nomes);
	}
}
