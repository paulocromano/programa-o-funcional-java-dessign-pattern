package strategy.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MediaSegundoSemestre implements CalculoNota {

	@Override
	public BigDecimal calcularNotas(Aluno aluno) {
		BigDecimal notaTotal = aluno.getNotasSegundoSemestre().stream().reduce(new BigDecimal("0"), BigDecimal::add);
		
		return notaTotal.divide(new BigDecimal(aluno.getNotasSegundoSemestre().size()), 2, RoundingMode.HALF_UP);
	}
}
