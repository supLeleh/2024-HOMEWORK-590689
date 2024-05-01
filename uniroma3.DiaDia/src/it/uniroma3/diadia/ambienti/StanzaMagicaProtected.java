package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	final static protected int SOGLIA_MAGICA_DEFAULT = 3;
	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;
	
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica=soglia;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.numeroAttrezzi >= NUMERO_MASSIMO_ATTREZZI)
			return false;
		this.contatoreAttrezziPosati++;
		
		if(this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo=this.modificaAttrezzo(attrezzo);
		
		for(int i=0; i<this.attrezzi.length; i++) {
			if(this.attrezzi[i]==null) {
				this.attrezzi[i]=attrezzo;
				this.numeroAttrezzi++;
				return true;
			}
		}
		return false;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2= attrezzo.getPeso()*2;
		nomeInvertito= new StringBuilder(attrezzo.getNome());
		nomeInvertito= nomeInvertito.reverse();
		attrezzo=new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
	}
}
