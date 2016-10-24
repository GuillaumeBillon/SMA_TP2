package modele;

import java.util.List;

public class Fournisseur extends Agent {
	// ATTRIBUTS
	List<Negociateur> listeNego;
	Service service;
	Float prixDepart;
	Long freqSoummission;
	
	// CONSTRUCTEURS
	public Fournisseur() {
		
	}
	
	public Fournisseur(List<Negociateur> listeNego, Service service, Float prixDepart, long freqSoummission) {
		this.listeNego = listeNego;
		this.service = service;
		this.prixDepart = prixDepart;
		this.freqSoummission = freqSoummission;
	}
	
	// METHODES
	public void run(){
		
	}
	
	public List<Negociateur> getListeNego() {
		return listeNego;
	}

	public void setListeNego(List<Negociateur> listeNego) {
		this.listeNego = listeNego;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Float getPrixDepart() {
		return prixDepart;
	}

	public void setPrixDepart(Float prixDepart) {
		this.prixDepart = prixDepart;
	}

	public Long getFreqSoummission() {
		return freqSoummission;
	}

	public void setFreqSoummission(Long freqSoummission) {
		this.freqSoummission = freqSoummission;
	}
	
	
}
