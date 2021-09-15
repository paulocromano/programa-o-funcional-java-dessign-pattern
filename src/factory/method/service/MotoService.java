package factory.method.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import factory.method.model.Veiculo;
import factory.method.repository.MotoRepository;
import util.ExecuteService;

public class MotoService implements ExecuteService {
	
	private List<Veiculo> motos = new ArrayList<>();
	
	
	public MotoService() {
		this.motos = new MotoRepository().gerarDados();
	}

	@Override
	public void execute() {
		//this.ordenarMotosPeloModelo();
		this.ordenarMotosPeloAnoEmOrdemDecrescente();
		//this.ordenarMotosPeloPreco();
	}
	
	public void ordenarMotosPeloModelo() {
		List<Veiculo> motosOrdenadas =  this.motos.stream()
			.sorted((Veiculo moto, Veiculo moto2) -> moto.getModelo().compareTo(moto2.getModelo()))
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		System.out.println("Ordenação de motos pelo modelo");
		motosOrdenadas.forEach(System.out::println);
	}
	
//	public void ordenarMotosPeloModelo() {
//		Comparator<Veiculo> comparator = new Comparator<Veiculo>() {
//
//			@Override
//			public int compare(Veiculo o1, Veiculo o2) {
//				return o1.getModelo().compareTo(o2.getModelo());
//			}
//		};
//		
//		Collections.sort(this.motos, comparator)
//	
//		System.out.println("Ordenação de motos pelo modelo");
//		this.motos.forEach(System.out::println);
//	}
	
	public void ordenarMotosPeloAnoEmOrdemDecrescente() {
		List<Veiculo> motosOrdenadas = this.motos.stream().sorted(Comparator.comparingInt(Veiculo::getAno).reversed()
				.thenComparing(Comparator.comparing(Veiculo::getModelo)))
			.collect(Collectors.toList());
		
		System.out.println("Ordenação de motos pelo ano em ordem decrescente");
		motosOrdenadas.forEach(System.out::println);
	}
	
//	public void ordenarMotosPeloAnoEmOrdemDecrescente() {
//		Comparator<Veiculo> comparator = new Comparator<Veiculo>() {
//
//			@Override
//			public int compare(Veiculo o1, Veiculo o2) {
//				return o1.getAno().compareTo(o2.getAno());
//			}
//		};
//		
//		Collections.sort(this.motos, comparator.reversed().thenComparing(Veiculo::getModelo));
//
//		System.out.println("Ordenação de motos pelo ano em ordem decrescente");
//		this.motos.forEach(System.out::println);
//	}
	
	public void ordenarMotosPeloPreco() {
		Comparator<Veiculo> comparator = Comparator.comparingInt(moto -> moto.getPreco());
		List<Veiculo> motosOrdenadas = this.motos.stream().sorted(comparator).collect(Collectors.toList());
		
		System.out.println("Ordenação de motos pelo perço");
		motosOrdenadas.forEach(System.out::println);
	}
}
