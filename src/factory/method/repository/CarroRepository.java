package factory.method.repository;

import java.util.Arrays;
import java.util.List;

import factory.method.model.CarroFactory;
import factory.method.model.Veiculo;
import factory.method.model.VeiculoFactory;

public class CarroRepository {

	public List<Veiculo> gerarDados() {
		VeiculoFactory carroFactory = new CarroFactory();
		
		return Arrays.asList(
				carroFactory.getVeiculo("HB 20", 2018, 75000),
				carroFactory.getVeiculo("Corolla", 2020, 120000),
				carroFactory.getVeiculo("Civic", 2021, 100000),
				carroFactory.getVeiculo("S10", 2016, 80000),
				carroFactory.getVeiculo("Gol", 2015, 25000),
				carroFactory.getVeiculo("Santana", 2006, 20000),
				carroFactory.getVeiculo("Camaro", 2021, 240000));
	}
}
