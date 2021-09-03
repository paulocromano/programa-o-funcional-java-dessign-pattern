package strategy.model;

import java.math.BigDecimal;
import java.util.List;

public class Aluno {

	private String ra;
	private String nome;
	private List<BigDecimal> notasPrimeiroSemestre;
	private List<BigDecimal> notasSegundoSemestre;
	
	
	public Aluno(String ra, String nome, List<BigDecimal> notasPrimeiroSemestre,
			List<BigDecimal> notasSegundoSemestre) {
		this.ra = ra;
		this.nome = nome;
		this.notasPrimeiroSemestre = notasPrimeiroSemestre;
		this.notasSegundoSemestre = notasSegundoSemestre;
	}


	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<BigDecimal> getNotasPrimeiroSemestre() {
		return notasPrimeiroSemestre;
	}

	public void setNotasPrimeiroSemestre(List<BigDecimal> notasPrimeiroSemestre) {
		this.notasPrimeiroSemestre = notasPrimeiroSemestre;
	}

	public List<BigDecimal> getNotasSegundoSemestre() {
		return notasSegundoSemestre;
	}

	public void setNotasSegundoSemestre(List<BigDecimal> notasSegundoSemestre) {
		this.notasSegundoSemestre = notasSegundoSemestre;
	}
}
