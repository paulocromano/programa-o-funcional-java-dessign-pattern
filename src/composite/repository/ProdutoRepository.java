package composite.repository;

import composite.model.ProdutoComposite;
import composite.model.ProdutoLeaf;

public class ProdutoRepository {

	public ProdutoComposite gerarDados() {
		ProdutoComposite produtoComposite = new ProdutoComposite();
		produtoComposite.add(
				new ProdutoLeaf("Caneta", 3.5D),
				new ProdutoLeaf("Caderno", 27.2D),
				new ProdutoLeaf("Estojo", 14.75D),
				new ProdutoLeaf("Camiseta", 48.55D),
				new ProdutoLeaf("Bolsa", 374.12D)
				);
		
		return produtoComposite;
	}
}
