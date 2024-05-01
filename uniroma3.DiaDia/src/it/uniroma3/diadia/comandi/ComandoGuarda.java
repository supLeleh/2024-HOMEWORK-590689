package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	
	private IO console;
	
	public ComandoGuarda(IO io) {
		this.console= io;
	}
	
	@Override
	public void esegui(Partita partita) {

		this.console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione() + "\nCfu rimanenti: " + partita.getPlay().getCfu());

	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}


	@Override
	public String getParametro() {
		return null;
	}
}
