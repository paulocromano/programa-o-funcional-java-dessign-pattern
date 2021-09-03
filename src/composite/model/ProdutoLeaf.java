package composite.model;

import java.util.Objects;

public class ProdutoLeaf implements ProdutoComponent {
	
	private String nome;
	private Double preco;
	

	public ProdutoLeaf(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	

	public String getNome() {
		return this.nome;
	}

	@Override
	public Double getPreco() {
		return this.preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoLeaf other = (ProdutoLeaf) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "ProdutoLeaf [nome=" + nome + ", preco=" + preco + "]";
	}
}
