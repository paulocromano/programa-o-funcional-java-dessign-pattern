package builder.repository;

import java.util.Arrays;
import java.util.List;

import builder.enums.EstadoCivil;
import builder.enums.Sexo;
import builder.model.Pessoa;

public class PessoaRepository {

	public List<Pessoa> gerarDados() {
		return Arrays.asList(
			new Pessoa.PessoaBuilder()
				.setNome("Ana Paula")
				.setSexo(Sexo.FEMININO)
				.setEstadoCivil(EstadoCivil.SOLTEIRO)
				.setTelefonePrincipal("99641-5291")
				.build(),
				
			new Pessoa.PessoaBuilder()
				.setNome("Juliana Monteiro")
				.setSexo(Sexo.FEMININO)
				.setEstadoCivil(EstadoCivil.CASADO)
				.setNomeConjuge("Adriano Monteiro")
				.setQuantidadeFilhos(2)
				.setTelefonePrincipal("99761-5341")
				.build(),
				
			new Pessoa.PessoaBuilder()
				.setNome("Gabriel Silva")
				.setSexo(Sexo.MASCULINO)
				.setEstadoCivil(EstadoCivil.VIUVO)
				.setNomeConjuge("Bianca Silva")
				.setQuantidadeFilhos(1)
				.setTelefonePrincipal("99618-7319")
				.setTelefoneRecado("3364-8514")
				.build(),
				
			new Pessoa.PessoaBuilder()
				.setNome("Joaquim Teixeira")
				.setSexo(Sexo.MASCULINO)
				.setEstadoCivil(EstadoCivil.DIVORCIADO)
				.setNomeConjuge("Camila Gonçalves")
				.setQuantidadeFilhos(0)
				.setTelefonePrincipal("99618-7319")
				.build()
				
		);
	}
}
