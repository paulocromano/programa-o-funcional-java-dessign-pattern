package strategy.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import strategy.model.Aluno;
import strategy.model.CalculoMediaFinal;
import strategy.model.CalculoNota;
import strategy.repository.AlunoRepository;
import util.ExecuteService;

public class AlunoService implements ExecuteService {
	
	private List<Aluno> alunos = new ArrayList<>();
	
	
	public AlunoService() {
		this.alunos = new AlunoRepository().gerarDados();
		
	}
	
	@Override
	public void execute() {
		//this.exibirMediaFinalDosAlunos();
		//this.calcularMediaGeralDosAlunosNoPrimeiroSemestre();
		this.calcularMediaGeralDosAlunosNoSegundoSemestre();
	}

	public void exibirMediaFinalDosAlunos() {
		CalculoNota calculo = new CalculoMediaFinal();
		
		System.out.println("\t Média final dos alunos");
		this.alunos.forEach(aluno -> System.out.println("Nome: " + aluno.getNome() 
			+ " - " + calculo.calcularNotas(aluno)));
	}
	
	public void calcularMediaGeralDosAlunosNoPrimeiroSemestre() {
		Double mediaGeralDosAlunos = this.alunos.stream()
				.flatMap(aluno -> aluno.getNotasPrimeiroSemestre().stream())
				.collect(Collectors.averagingDouble(BigDecimal::doubleValue));
		
		System.out.println("Média geral dos alunos no primeiro semestre: " + mediaGeralDosAlunos);
	}
	
	public void calcularMediaGeralDosAlunosNoSegundoSemestre() {
		Double mediaGeralDosAlunos = this.alunos.stream()
				.collect(Collectors.flatMapping(aluno -> aluno.getNotasSegundoSemestre().stream(), 
						Collectors.averagingDouble(nota -> nota.doubleValue())));
		
		System.out.println("Média geral dos alunos no segundo semestre: " + mediaGeralDosAlunos);
	}
}
