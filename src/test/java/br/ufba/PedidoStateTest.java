package br.ufba;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Before;
import org.junit.Test;

import br.ufba.Armazem;
import br.ufba.Pedido;

public class PedidoStateTest {
	
	private static final String TALISMA = "talismã";
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testPedidoEhExecutadoSeTemSuficienteNoArmazem() throws Exception {
		// setup
		Armazem armazem = mock(Armazem.class);
		when(armazem.getQtdProduto(TALISMA)).thenReturn(50);
		Pedido order = new Pedido(TALISMA, 20);
		
		// execute
		order.executa(armazem);
		
		// verify
		assertThat(order.foiExecutado(), is(true));
	}
	
	@Test
	public void testPedidoNaoEhExecutadoSeNaoTemSuficienteNoArmazem() throws Exception {
		// setup
		Armazem armazem = mock(Armazem.class);
		when(armazem.getQtdProduto(TALISMA)).thenReturn(10);
		Pedido pedido = new Pedido(TALISMA, 20);
		
		// execute
		pedido.executa(armazem);
		
		// verify
		assertThat(pedido.foiExecutado(), is(false));
	}

}
