package factory.method.model;

public class Moto implements Veiculo {
	
	private String modelo;
	private Integer ano;
	private Integer preco;
	

	public Moto(String modelo, Integer ano, Integer preco) {
		this.modelo = modelo;
		this.ano = ano;
		this.preco = preco;
	}


	@Override
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}


	@Override
	public Double calcularDesconto() {
		final double desconto = 0.15;
		return this.preco * desconto;
	}


	@Override
	public String toString() {
		return "Moto [modelo=" + modelo + ", ano=" + ano + ", preco=" + preco + "]";
	}
}
