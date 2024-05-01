package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */

public class ComandoVai implements Comando{
	private String direzione;
	private IO console;
	
	public ComandoVai(IO console) {
		this.console = console;
	}
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.direzione==null) {
			this.console.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			this.console.mostraMessaggio("Direzione insesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		this.console.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getPlay().setCfu(partita.getPlay().getCfu()-1);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione  = parametro;
	}
	
	@Override
	public String getNome() {
		return "vai";
	}


	@Override
	public String getParametro() {
		return this.direzione;
	}

}
