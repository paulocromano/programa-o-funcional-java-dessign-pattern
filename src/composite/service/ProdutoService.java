package composite.service;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import composite.model.ProdutoComponent;
import composite.model.ProdutoComposite;
import composite.repository.ProdutoRepository;
import util.ExecuteService;

public class ProdutoService implements ExecuteService {
	
	private ProdutoComposite produtoComposite = new ProdutoComposite();
	
	
	public ProdutoService() {
		this.produtoComposite = new ProdutoRepository().gerarDados();
	}

	@Override
	public void execute() {
		//this.exibirProdutos();
		//this.exibirPrecoTotalProdutos();
		//this.buscarProdutoMaisBarato();
		//this.buscarProdutoMaisCaro();
		this.exibirEstatiscasDosProdutos();
	}
	
	public void exibirProdutos() {
		System.out.println("Produtos");
		this.produtoComposite.getProdutos().forEach(System.out::println);
	}

	public void exibirPrecoTotalProdutos() {
		Double precoTotal = this.produtoComposite.getPreco();
		System.out.println("Preço total dos produtos R$: " + precoTotal);
	}
	
	public void buscarProdutoMaisBarato() {
		Optional<ProdutoComponent> produtoMaisBarato = this.produtoComposite.getProdutos().stream()
				.min(Comparator.comparingDouble(produto -> produto.getPreco()));
			
			System.out.println("Produto mais barato");
			produtoMaisBarato.ifPresent(System.out::println);
	}
	
	public void buscarProdutoMaisCaro() {
		Optional<ProdutoComponent> produtoMaisCaro = this.produtoComposite.getProdutos().stream()
			.max(Comparator.comparingDouble(ProdutoComponent::getPreco));
		
		System.out.println("Produto mais caro");
		produtoMaisCaro.ifPresent(System.out::println);
	}
	
//	public void buscarProdutoMaisCaro() {
//		Optional<ProdutoComponent> optionalProdutoMaisCaro = Optional.empty();
//		
//		if (!this.produtoComposite.getProdutos().isEmpty()) {
//			ProdutoComponent produtoMaisCaro = this.produtoComposite.getProdutos().get(0);
//			
//			for (ProdutoComponent produto : this.produtoComposite.getProdutos()) {
//				if (produto.getPreco() > produtoMaisCaro.getPreco()) {
//					produtoMaisCaro = produto;
//				}
//			}
//			
//			optionalProdutoMaisCaro = Optional.of(produtoMaisCaro);
//		}
//		
//		System.out.println("Produto mais caro");
//		optionalProdutoMaisCaro.ifPresent(System.out::println);
//	}
	
	public void exibirEstatiscasDosProdutos() {
		DoubleSummaryStatistics estatisticas =  this.produtoComposite.getProdutos().stream()
				.collect(Collectors.summarizingDouble(ProdutoComponent::getPreco));
		
		System.out.println("Estatísticas dos Preços dos produtos: " + estatisticas);
	}
}
