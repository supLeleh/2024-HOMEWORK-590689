package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi", "borsa"};

	private Partita partita;
	private IOConsole console;

	public DiaDia() {
		this.partita = new Partita();
		this.console = new IOConsole();
	}

	public void gioca() {
		String istruzione; 

		this.console.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do	{	
			istruzione = this.console.leggiRiga();
		}while (!processaIstruzione(istruzione));

	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(istruzione.isEmpty()) return false;
		if (comandoDaEseguire.getNome().equals("fine")|| this.partita.isFinita()) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("borsa"))
			this.apri();
		else
			this.console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.console.mostraMessaggio(elencoComandi[i]+" ");
		this.console.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlay().getCfu();
			this.partita.getPlay().setCfu(--cfu);
		}
		this.console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	/**
	 * Seleziona il nome di un oggetto da posare nella stanza
	 */
	private void posa(String attrezzo) {
		if(attrezzo==null)
			this.console.mostraMessaggio("Che attrezzo vuoi posare?");
		Attrezzo selezionato = null;
		boolean ver = this.partita.getPlay().getBorsa().searchAtt(attrezzo);
		selezionato = this.partita.getPlay().getBorsa().getAttrezzo(attrezzo);
		if(!ver)
			this.console.mostraMessaggio("Attrezzo non presente nella borsa");
		else {
			this.partita.getStanzaCorrente().addAttrezzo(selezionato);
			this.partita.getPlay().getBorsa().removeAttrezzo(attrezzo);
			this.console.mostraMessaggio("Oggetto posato");
		}

	}
	/**
	 * Seleziona il nome di un oggetto da prendere dalla stanza
	 */
	private void prendi(String attrezzo) {
		if(attrezzo==null)
			this.console.mostraMessaggio("Che attrezzo vuoi posare?");
		Attrezzo selezionato = null;
		boolean ver = this.partita.getStanzaCorrente().searchAtt(attrezzo);
		selezionato = this.partita.getStanzaCorrente().getAttrezzo(attrezzo);
		if(!ver) {
			this.console.mostraMessaggio("Attrezzo non presente nella stanza");
		}
		else {
			this.partita.getPlay().getBorsa().addAttrezzo(selezionato);
			this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			this.console.mostraMessaggio("Oggetto raccolto");
		}

	}
	/**
	 * apri la borsa
	 */
	private void apri() {
		this.console.mostraMessaggio(this.partita.getPlay().getBorsa().toString());
	}

	/**S
	 * Comando "Fine".
	 */
	private void fine() {
		this.console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}