package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Seleziona il nome di un oggetto da posare nella stanza
 */

public class ComandoPosa implements Comando{
	private String attrezzo;
	private IO console;
	
	public ComandoPosa(IO console) {
		this.console=console;
	}
	@Override
	public void esegui(Partita partita) {
		if(attrezzo==null)
			this.console.mostraMessaggio("Che attrezzo vuoi posare?");
		Attrezzo selezionato = null;
		boolean ver = partita.getPlay().getBorsa().searchAtt(attrezzo);
		selezionato = partita.getPlay().getBorsa().getAttrezzo(attrezzo);
		if(!ver)
			this.console.mostraMessaggio("Attrezzo non presente nella borsa");
		else {
			partita.getStanzaCorrente().addAttrezzo(selezionato);
			partita.getPlay().getBorsa().removeAttrezzo(attrezzo);
			this.console.mostraMessaggio("Oggetto posato");
		}

	}
	
	@Override
	public void setParametro(String parametro) {
		this.attrezzo  = parametro;
	}
	
	@Override
	public String getNome() {
		return "posa";
	}


	@Override
	public String getParametro() {
		return this.attrezzo;
	}
}
