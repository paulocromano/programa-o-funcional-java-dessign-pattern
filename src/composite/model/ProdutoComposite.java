package composite.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdutoComposite implements ProdutoComponent {
	
	private List<ProdutoComponent> produtos = new ArrayList<>();
	
	
	public List<ProdutoComponent> getProdutos() {
		return produtos;
	}

	@Override
	public Double getPreco() {
		return this.produtos.stream().mapToDouble(ProdutoComponent::getPreco)
				.reduce(0, (subtotal, proximoElemento) -> subtotal + proximoElemento);
	}

	public void add(ProdutoComponent... produtos) {
		this.produtos.addAll(Arrays.asList(produtos));
	}
	
	public void remover(ProdutoComponent produto) {
		this.produtos.remove(produto);
	}
}
