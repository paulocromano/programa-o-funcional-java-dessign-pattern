package strategy.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class MediaPrimeiroSemestre implements CalculoNota {

	@Override
	public BigDecimal calcularNotas(Aluno aluno) {
		Optional<BigDecimal> notaTotal = aluno.getNotasPrimeiroSemestre().stream().reduce(BigDecimal::add);
		
		return notaTotal.isPresent() ? 
				notaTotal.get().divide(new BigDecimal(aluno.getNotasPrimeiroSemestre().size()), 2, RoundingMode.HALF_UP)
				: new BigDecimal("0");
	}
}
