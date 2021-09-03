package strategy.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import strategy.model.Aluno;

public class AlunoRepository {

	public List<Aluno> gerarDados() {
		return Arrays.asList(
			new Aluno("19557522074", "Luana", 
				Arrays.asList(new BigDecimal("7.62"),
						new BigDecimal("5.10"),
						new BigDecimal("9.00"),
						new BigDecimal("6.40")), 
				Arrays.asList(new BigDecimal("8.42"),
						new BigDecimal("8.17"),
						new BigDecimal("4.70"),
						new BigDecimal("3.95"))),
			new Aluno("195573612010", "Willian", 
				Arrays.asList(new BigDecimal("9.64"),
						new BigDecimal("10.00"),
						new BigDecimal("9.56"),
						new BigDecimal("7.40")), 
				Arrays.asList(new BigDecimal("4.49"),
						new BigDecimal("7.77"),
						new BigDecimal("5.70"),
						new BigDecimal("7.95"))),
			new Aluno("63457522074", "Marcelo", 
				Arrays.asList(new BigDecimal("8.72"),
						new BigDecimal("5.70"),
						new BigDecimal("9.80"),
						new BigDecimal("7.90")), 
				Arrays.asList(new BigDecimal("9.52"),
						new BigDecimal("8.86"),
						new BigDecimal("4.54"),
						new BigDecimal("3.34"))));
	}
}
