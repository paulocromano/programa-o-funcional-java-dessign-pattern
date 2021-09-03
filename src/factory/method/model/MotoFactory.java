package factory.method.model;

public class MotoFactory extends VeiculoFactory {

	@Override
	public Veiculo getVeiculo(String modelo, Integer ano, Integer preco) {
		return new Moto(modelo, ano, preco);
	}
}
