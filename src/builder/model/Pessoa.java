package builder.model;

import builder.enums.EstadoCivil;
import builder.enums.Sexo;

public class Pessoa {

	private String nome;
	private Sexo sexo;
	private EstadoCivil estadoCivil;
	private String nomeConjuge;
	private Integer quantidadeFilhos;
	private String telefonePrincipal;
	private String telefoneRecado;
	
	
	public Pessoa() { }

	private Pessoa(String nome, Sexo sexo, EstadoCivil estadoCivil, String nomeConjuge,
			Integer quantidadeFilhos, String telefonePrincipal, String telefoneRecado) {

		this.nome = nome;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.nomeConjuge = nomeConjuge;
		this.quantidadeFilhos = quantidadeFilhos;
		this.telefonePrincipal = telefonePrincipal;
		this.telefoneRecado = telefoneRecado;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public Integer getQuantidadeFilhos() {
		return quantidadeFilhos;
	}

	public void setQuantidadeFilhos(Integer quantidadeFilhos) {
		this.quantidadeFilhos = quantidadeFilhos;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneRecado() {
		return telefoneRecado;
	}

	public void setTelefoneRecado(String telefoneRecado) {
		this.telefoneRecado = telefoneRecado;
	}
	
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sexo=" + sexo + ", estadoCivil=" 
				+ estadoCivil + ", nomeConjuge=" + nomeConjuge + ", quantidadeFilhos=" 
				+ quantidadeFilhos + ", telefonePrincipal=" + telefonePrincipal
				+ ", telefoneRecado=" + telefoneRecado + "]";
	}


	public static class PessoaBuilder {
		private String nome;
		private Sexo sexo;
		private EstadoCivil estadoCivil;
		private String nomeConjuge;
		private Integer quantidadeFilhos;
		private String telefonePrincipal;
		private String telefoneRecado;
		
		
		public PessoaBuilder setNome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public PessoaBuilder setSexo(Sexo sexo) {
			this.sexo = sexo;
			return this;
		}
		
		public PessoaBuilder setEstadoCivil(EstadoCivil estadoCivil) {
			this.estadoCivil = estadoCivil;
			return this;
		}
		
		public PessoaBuilder setNomeConjuge(String nomeConjuge) {
			this.nomeConjuge = nomeConjuge;
			return this;
		}
		
		public PessoaBuilder setQuantidadeFilhos(Integer quantidadeFilhos) {
			this.quantidadeFilhos = quantidadeFilhos;
			return this;
		}
		
		public PessoaBuilder setTelefonePrincipal(String telefonePrincipal) {
			this.telefonePrincipal = telefonePrincipal;
			return this;
		}
		
		public PessoaBuilder setTelefoneRecado(String telefoneRecado) {
			this.telefoneRecado = telefoneRecado;
			return this;
		}
		
		
		public Pessoa build() {
			return new Pessoa(nome, sexo, estadoCivil, nomeConjuge, 
					quantidadeFilhos, telefonePrincipal, telefoneRecado);
		}
	}
}
