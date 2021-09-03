package factory.method.repository;

import java.util.Arrays;
import java.util.List;

import factory.method.model.MotoFactory;
import factory.method.model.Veiculo;
import factory.method.model.VeiculoFactory;

public class MotoRepository {

	public List<Veiculo> gerarDados() {
		VeiculoFactory motoFactory = new MotoFactory();
		
		return Arrays.asList(
				motoFactory.getVeiculo("Titan 160", 2021, 12500),
				motoFactory.getVeiculo("Titan 125", 2020, 10000),
				motoFactory.getVeiculo("Biz", 2021, 9000),
				motoFactory.getVeiculo("CB Twister", 2019, 16000),
				motoFactory.getVeiculo("CB 500", 2018, 30000),
				motoFactory.getVeiculo("CB 650R", 2019, 60000));
	}
}
