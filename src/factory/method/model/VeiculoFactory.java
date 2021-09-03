package factory.method.model;

public abstract class VeiculoFactory {

	public abstract Veiculo getVeiculo(String modelo, Integer ano, Integer preco);
}
