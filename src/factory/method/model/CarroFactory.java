package factory.method.model;

public class CarroFactory extends VeiculoFactory {
	
	@Override
	public Veiculo getVeiculo(String modelo, Integer ano, Integer preco) {
		return new Carro(modelo, ano, preco);
	}
}
