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
	
//	@Override
//	public BigDecimal calcularNotas(Aluno aluno) {
//		Optional<BigDecimal> notaTotal = Optional.empty();
//		
//		if (!aluno.getNotasPrimeiroSemestre().isEmpty()) {
//			BigDecimal somaNotas = new BigDecimal("0");
//			
//			for (BigDecimal nota : aluno.getNotasPrimeiroSemestre()) {
//				somaNotas = somaNotas.add(nota);
//			}
//			
//			notaTotal = Optional.of(somaNotas);
//		}
//
//		return notaTotal.isPresent() ? 
//				notaTotal.get().divide(new BigDecimal(aluno.getNotasPrimeiroSemestre().size()), 2, RoundingMode.HALF_UP)
//				: new BigDecimal("0");
//	}
}
