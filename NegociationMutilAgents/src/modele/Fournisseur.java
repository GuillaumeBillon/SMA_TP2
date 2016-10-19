package modele;

import java.util.List;

public class Fournisseur extends Agent {
	List<Negociateur> listeNego;
	Service service;
	
	public Fournisseur() {
		
	}
	
	public Fournisseur(List<Negociateur> listeNego, Service service) {
		this.listeNego = listeNego;
		this.service = service;
	}

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
	
	
}
