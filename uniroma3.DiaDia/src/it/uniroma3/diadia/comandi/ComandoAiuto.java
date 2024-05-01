package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi", "guarda"};
	private IO console;
	
	public ComandoAiuto(IO io) {
		this.console = io;
	}
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.console.mostraMessaggio(elencoComandi[i]+" ");
		this.console.mostraMessaggio("");
	}
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public String getNome() {
		return "aiuto";
	}


	@Override
	public String getParametro() {
		return null;
	}

}
