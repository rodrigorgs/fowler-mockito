package org.tiqwab.example.mockito;

public class Pedido {
	private String codigoProduto;
	private int qtd;
	private boolean foiExecutado;
	
	public Pedido(String codigoProduto, int qtd) {
		this.codigoProduto = codigoProduto;
		this.qtd = qtd;
		this.foiExecutado = false;
	}
	
	public void executa(Armazem armazem) {
		int inventory = armazem.getQtdProduto(this.codigoProduto);
		if (this.qtd <= inventory) {
			this.foiExecutado = true;
			armazem.remove(this.codigoProduto, this.qtd);
		}
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public int getQtd() {
		return qtd;
	}

	public boolean foiExecutado() {
		return foiExecutado;
	}
}
