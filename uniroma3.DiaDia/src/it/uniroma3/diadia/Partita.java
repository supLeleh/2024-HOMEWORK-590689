package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	
	private Labirinto lab;
	private boolean finita;
	private Giocatore play;
	private Stanza stanzaCorrente;
	
	public Partita(){
		this.lab=new Labirinto();
		this.finita = false;
		this.play = new Giocatore();
		this.stanzaCorrente= this.getLab().getStanzaIniziale();
	}

	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}



	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.lab.getStanzaVincente();

		//return this.lab.getStanzaCorrente().equals(this.lab.getStanzaVincente());
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (play.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public Labirinto getLab() {
		return lab;
	}

	public void setLab(Labirinto lab) {
		this.lab = lab;
	}

	public Giocatore getPlay() {
		return play;
	}

	public void setPlay(Giocatore play) {
		this.play = play;
	}
	
	
}
