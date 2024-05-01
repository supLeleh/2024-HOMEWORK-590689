package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private Stanza stanzaBuia;
	private Attrezzo lanterna;
	
	@Before
	public void setUp() throws Exception {
		
		stanzaBuia= new StanzaBuia("Stanza Buia");
		lanterna = new Attrezzo("lanterna", 5);
	}

	@Test
	public void testLanternaNonPresente() {
		assertEquals("Qui c'è un buio pesto!", this.stanzaBuia.getDescrizione());
	}
	@Test
	public void testAttrezzoPresente() {
		this.stanzaBuia.addAttrezzo(lanterna);
		assertEquals(this.stanzaBuia.toString(), this.stanzaBuia.getDescrizione());
	}

}
