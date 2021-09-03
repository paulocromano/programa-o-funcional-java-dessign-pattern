package adapter.model;

import java.time.LocalDate;

import adapter.enums.TipoPessoa;

public class Cliente {

	private String nome;
	private Boolean isDeficiente;
	private TipoPessoa tipoPessoa;
	private LocalDate dataNascimento;
	
	
	public Cliente(String nome, Boolean isDeficiente, TipoPessoa tipoPessoa, LocalDate dataNascimento) {
		this.nome = nome;
		this.isDeficiente = isDeficiente;
		this.tipoPessoa = tipoPessoa;
		this.dataNascimento = dataNascimento;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIsDeficiente() {
		return isDeficiente;
	}

	public void setIsDeficiente(Boolean isDeficiente) {
		this.isDeficiente = isDeficiente;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", isDeficiente=" + isDeficiente + ", tipoPessoa=" + tipoPessoa
				+ ", dataNascimento=" + dataNascimento + "]";
	}



}
