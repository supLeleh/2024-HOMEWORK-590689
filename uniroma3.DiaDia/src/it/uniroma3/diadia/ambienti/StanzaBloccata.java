package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzionelock;
	private String chiave;
	
	public StanzaBloccata(String nome, String dir, String chiave){
		super(nome);
		this.direzionelock=dir;
		this.chiave=chiave;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir.equals(direzionelock))
		if(!(super.searchAtt(chiave))) 
			return this;
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		if(super.searchAtt(chiave))
			return super.getDescrizione();
		return "Stanza bloccata, serve una chiave";
	}
}
