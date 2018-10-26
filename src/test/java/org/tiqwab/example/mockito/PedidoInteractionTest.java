package org.tiqwab.example.mockito;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Before;
import org.junit.Test;

public class PedidoInteractionTest {

	private static final String TALISMA = "talismã";
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testExecutarPedidoRemoveDoInventarioSeTiverEstoque() throws Exception {
		// setup
		Pedido pedido = new Pedido(TALISMA, 20);
		Armazem armazem = mock(Armazem.class);
		when(armazem.getQtdProduto(TALISMA)).thenReturn(50);
		
		// execute
		pedido.executa(armazem);
		
		// verify
		assertThat(pedido.foiExecutado(), is(true));
		verify(armazem, times(1)).getQtdProduto(TALISMA);
		verify(armazem, times(1)).remove(TALISMA, 20);
	}
	
	@Test
	public void testExecutarPedidoNaoRemoveDoInventarioSeNaoTiverEstoque() throws Exception {
		// setup
		Pedido pedido = new Pedido(TALISMA, 20);
		Armazem armazem = mock(Armazem.class);
		when(armazem.getQtdProduto(TALISMA)).thenReturn(10);
		
		// execute
		pedido.executa(armazem);
		
		// verify
		assertThat(pedido.foiExecutado(), is(false));
		verify(armazem, times(1)).getQtdProduto(TALISMA);
		verify(armazem, never()).remove(eq(TALISMA), anyInt());
	}
	
}
