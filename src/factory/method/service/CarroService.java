package factory.method.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import factory.method.dto.VeiculoDTO;
import factory.method.model.Veiculo;
import factory.method.repository.CarroRepository;
import util.ExecuteService;

public class CarroService implements ExecuteService {
	
	private List<Veiculo> carros = new ArrayList<>();
	
	public CarroService() {
		this.carros = new CarroRepository().gerarDados();
	}

	@Override
	public void execute() {
		//this.exibirDTODeCarros();
		//this.precoTotalDosCarros();
		//this.buscarCarrosComPrecoMaior(10000);
		this.totalDeCarrosDepoisDoAno(2016);
	}
	
	
	public void exibirDTODeCarros() {
		List<VeiculoDTO> carros = VeiculoDTO.converterParaDTO(this.carros);
		
		System.out.println("Lista de Carros");
		carros.forEach(System.out::println);
	}
	
	public void precoTotalDosCarros() {
		int precoTotal = this.carros.stream().mapToInt(Veiculo::getPreco).sum();
		System.out.println("Preço total dos carros R$ " + precoTotal);
	}
	
	public void buscarCarrosComPrecoMaior(Integer preco) {
		List<Veiculo> carros = this.carros.stream()
				.filter(carro -> carro.getPreco() > preco).limit(2L)
				.collect(Collectors.toList());
		
		System.out.println("Carros com preço maior que R$ " + preco);
		carros.forEach(System.out::println);
	}
	
	public void totalDeCarrosDepoisDoAno(Integer ano) {
		long totalDeCarros = this.carros.stream().filter(carro -> carro.getAno() > ano).count();
		
		System.out.println("Total de carros depois do ano " + ano + ": " + totalDeCarros);
	}
}
