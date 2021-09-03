package factory.method.dto;

import java.util.List;
import java.util.stream.Collectors;

import factory.method.model.Veiculo;

public class VeiculoDTO {

	private String modelo;
	private Integer ano;
	private Integer preco;
	
	
	public VeiculoDTO(Veiculo veiculo) {
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
		this.preco = veiculo.getPreco();
	}


	public String getModelo() {
		return modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public Integer getPreco() {
		return preco;
	}
	
	
	public static List<VeiculoDTO> converterParaDTO(List<Veiculo> veiculos) {
		return veiculos.stream().map(veiculo -> new VeiculoDTO(veiculo)).collect(Collectors.toList());
		//return veiculos.stream().map(VeiculoDTO::new).collect(Collectors.toList());
	}


	@Override
	public String toString() {
		return "VeiculoDTO [modelo=" + modelo + ", ano=" + ano + ", preco=" + preco + "]";
	}
}
