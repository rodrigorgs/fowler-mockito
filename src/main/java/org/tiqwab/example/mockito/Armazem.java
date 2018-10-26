package org.tiqwab.example.mockito;

public interface Armazem {
	
	public int getQtdProduto(String codigoProduto);
	public void remove(String codigoProduto, int qtd);
	
}
