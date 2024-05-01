package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private Stanza stanzaMagica;
	private Attrezzo spada;
	private Attrezzo lama;
	private Attrezzo carta;

	@Before
	public void setUp() throws Exception {
		this.stanzaMagica = new StanzaMagica("Stanza Magica",2);
		this.spada= new Attrezzo("spada",10);
		this.lama= new Attrezzo("lama",2);
		this.carta= new Attrezzo("carta",1);
	}

	@Test
	public void testAddAttrrezzo() {
		this.stanzaMagica.addAttrezzo(this.spada);
		assertTrue(stanzaMagica.searchAtt(spada.getNome()));
	}
	@Test
	public void testAddAttrezzoMagico() {
		this.stanzaMagica.addAttrezzo(this.spada);
		this.stanzaMagica.addAttrezzo(this.lama);
		this.stanzaMagica.addAttrezzo(this.carta);
		assertTrue(stanzaMagica.searchAtt("atrac"));
	}
	@Test
	public void testAddSecondoAttrezzoMagico() {
		this.stanzaMagica.addAttrezzo(this.spada);
		this.stanzaMagica.addAttrezzo(this.lama);
		this.stanzaMagica.addAttrezzo(this.carta);
		Attrezzo palla = new Attrezzo("palla",5);
		this.stanzaMagica.addAttrezzo(palla);
		assertTrue(stanzaMagica.searchAtt("allap"));
	}

}
