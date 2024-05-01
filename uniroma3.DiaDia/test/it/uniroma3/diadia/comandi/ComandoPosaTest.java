package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosaTest {
	
	private Partita p;
	private Comando c;
	private IOConsole console;
	
	@Before
	public void setUp() throws Exception {
		console = new IOConsole();
		p = new Partita();
		c = new ComandoPosa(console);
		p.getPlay().getBorsa().addAttrezzo(new Attrezzo("spada",10));
	}

	@Test
	public void testComandoPosaNellaStanza() {
		c.setParametro("spada");
		c.esegui(p);
		assertTrue(p.getStanzaCorrente().searchAtt("spada"));
	}
	@Test
	public void testComandoPosaNellaBorsa() {
		c.setParametro("spada");
		c.esegui(p);
		assertFalse(p.getPlay().getBorsa().searchAtt("spada"));
	}
	@Test
	public void testComandoPosaAttrezzoNonPresente() {
		c.setParametro("piccone");
		c.esegui(p);
		assertFalse(p.getStanzaCorrente().searchAtt("piccone"));
	}
}
