package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String attrezzo;
	
	public StanzaBuia(String nome) {
		super(nome);
		this.attrezzo="lanterna";
	}
	
	@Override
	public String getDescrizione() {
		if(super.searchAtt(this.attrezzo))
			return super.getDescrizione();
		return "Qui c'è un buio pesto!";
	}
	
}


