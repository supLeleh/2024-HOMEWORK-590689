package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Seleziona il nome di un oggetto da prendere dalla stanza
 */

public class ComandoPrendi implements Comando{
	private String attrezzo;
	private IO console;
	
	public ComandoPrendi(IO console) {
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		
		if(this.attrezzo==null)
			this.console.mostraMessaggio("Che attrezzo vuoi posare?");
		Attrezzo selezionato = null;
		boolean ver = partita.getStanzaCorrente().searchAtt(attrezzo);
		selezionato = partita.getStanzaCorrente().getAttrezzo(attrezzo);
		if(!ver) {
			this.console.mostraMessaggio("Attrezzo non presente nella stanza");
		}
		else {
			partita.getPlay().getBorsa().addAttrezzo(selezionato);
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			this.console.mostraMessaggio("Oggetto raccolto");
		}

	}
	
	@Override
	public void setParametro(String parametro) {
		this.attrezzo  = parametro;
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}


	@Override
	public String getParametro() {
		return this.attrezzo;
	}
}
