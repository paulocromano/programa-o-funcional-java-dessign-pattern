package adapter.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import adapter.enums.TipoPessoa;
import adapter.model.Cliente;

public class PostgreSQL implements DbAdapter<Cliente> {

	@Override
	public List<Cliente> buscar() {
		return Arrays.asList(
				new Cliente("João Pedro", true, TipoPessoa.FISICA, LocalDate.of(1990, Month.JANUARY, 12)),
				new Cliente("Rebeca", true, TipoPessoa.JURIDICA, LocalDate.of(1985, Month.APRIL, 20)),
				new Cliente("Pedro", false, TipoPessoa.JURIDICA, LocalDate.of(1992, Month.AUGUST, 2)),
				new Cliente("Pamela", false, TipoPessoa.FISICA, LocalDate.of(1996, Month.FEBRUARY, 5)),
				new Cliente("Paola", false, TipoPessoa.FISICA, LocalDate.of(1996, Month.FEBRUARY, 15)),
				new Cliente("Daniel", true, TipoPessoa.FISICA, LocalDate.of(1996, Month.MARCH, 24)),
				new Cliente("Abraão", false, TipoPessoa.JURIDICA, LocalDate.of(1997, Month.SEPTEMBER, 10)),
				new Cliente("Daniela", false, TipoPessoa.JURIDICA, LocalDate.of(1996, Month.MAY, 17)));
	}
}
