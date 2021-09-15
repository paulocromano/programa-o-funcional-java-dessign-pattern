package builder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import builder.enums.EstadoCivil;
import builder.enums.Sexo;
import builder.model.Pessoa;
import builder.repository.PessoaRepository;
import util.ExecuteService;

public class PessoaService implements ExecuteService {
	
	private List<Pessoa> pessoas = new ArrayList<>();

	public PessoaService() {
		this.pessoas =  new PessoaRepository().gerarDados();
	}

	@Override
	public void execute() {
		//this.filtrarPessoasPorSexo(Sexo.FEMININO);
		//this.filtrarPessoasPeloEstadoCivil(EstadoCivil.CASADO);
		//this.filtrarPessoasQuePossuemFilhos();
		this.encontrarPrimeiraPessoaComNomeIgual("Joaquim");
	}
	
	
	public void filtrarPessoasPorSexo(Sexo sexo) {
		List<Pessoa> pessoasFiltradas = this.pessoas.stream()
			.filter(pessoa -> pessoa.getSexo().equals(sexo))
			.collect(() -> new ArrayList<Pessoa>(), 
					(List<Pessoa> accumulatorPessoas, Pessoa pessoa) -> accumulatorPessoas.add(pessoa), 
					(List<Pessoa> combinerPessoas, List<Pessoa> listaPessoas) -> combinerPessoas.addAll(listaPessoas));
		
		System.out.println("Filtragem de pessoas pelo sexo");
		pessoasFiltradas.forEach(pessoa -> System.out.println(pessoa));
	}
	
	public void filtrarPessoasPeloEstadoCivil(EstadoCivil estadoCivil) {
		Supplier<List<Pessoa>> supplier = () -> new ArrayList<>();
		BiConsumer<List<Pessoa>, Pessoa> accumulator = 
				(List<Pessoa> accumulatorPessoas, Pessoa pessoa) -> accumulatorPessoas.add(pessoa);	
		BiConsumer<List<Pessoa>, List<Pessoa>> combiner = 
				(List<Pessoa> combinerPessoas, List<Pessoa> listaPessoas) -> combinerPessoas.addAll(listaPessoas);
						
		List<Pessoa> pessoasFiltradas = this.pessoas.stream()
				.filter(pessoa -> pessoa.getEstadoCivil().equals(estadoCivil))
				.collect(supplier, accumulator, combiner);
			
		System.out.println("Filtragem de pessoas pelo estado civil");
		pessoasFiltradas.forEach(pessoa -> System.out.println(pessoa));
	}
	
	public void filtrarPessoasQuePossuemFilhos() {
		Predicate<Pessoa> predicate = pessoa -> Objects.nonNull(pessoa.getQuantidadeFilhos())
				&& pessoa.getQuantidadeFilhos() > 0;
				
		List<String> nomes = this.pessoas.stream().filter(predicate).collect(
				Collectors.mapping(Pessoa::getNome, Collectors.toCollection(ArrayList::new)));
		
		System.out.println("Filtragem de pessoas que possuem filhos");
		nomes.forEach(System.out::println);
	}
	
//	public void filtrarPessoasQuePossuemFilhos() {				
//		List<String> nomes = new ArrayList<>();
//		
//		for (Pessoa pessoa : this.pessoas) {
//			if (Objects.nonNull(pessoa.getQuantidadeFilhos())
//				&& pessoa.getQuantidadeFilhos() > 0) {
//				nomes.add(pessoa.getNome());
//			}
//		}
//		
//		System.out.println("Filtragem de pessoas que possuem filhos");
//		nomes.forEach(System.out::println);
//	}
	
	public void encontrarPrimeiraPessoaComNomeIgual(String nome) {
		this.pessoas.stream().filter(pessoa -> pessoa.getNome().contains(nome))
			.findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("Pessoa não encontrada!"));
	}
	
//	public void encontrarPrimeiraPessoaComNomeIgual(String nome) {
//		Optional<Pessoa> optionalPessoa = Optional.empty();
//		
//		for (Pessoa pessoa : this.pessoas) {
//			if (pessoa.getNome().contains(nome)) {
//				optionalPessoa = Optional.of(pessoa);
//				break;
//			}
//		}
//		
//		if (optionalPessoa.isPresent()) {
//			System.out.println(optionalPessoa.get());
//		}
//		else {
//			System.out.println("Pessoa não encontrada!");
//		}
//	}
}
