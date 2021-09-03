package strategy.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculoMediaFinal implements CalculoNota {

	@Override
	public BigDecimal calcularNotas(Aluno aluno) {
		CalculoNota calculo = new MediaPrimeiroSemestre();
		BigDecimal mediaPrimeiroSemestre = calculo.calcularNotas(aluno);
		
		calculo = new MediaSegundoSemestre();
		BigDecimal mediaSegundoSemestre = calculo.calcularNotas(aluno);
		
		return (mediaPrimeiroSemestre.add(mediaSegundoSemestre))
				.divide(new BigDecimal("2"), 2, RoundingMode.HALF_UP);
	}
}
