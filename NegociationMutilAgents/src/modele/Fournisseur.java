package modele;

import java.util.List;

public class Fournisseur extends Agent {
	List<Negociateur> listeNego;
	
	public Fournisseur() {
		
	}
	
	public Fournisseur(List<Negociateur> listeNego) {
		this.listeNego = listeNego;
	}

	public List<Negociateur> getListeNego() {
		return listeNego;
	}

	public void setListeNego(List<Negociateur> listeNego) {
		this.listeNego = listeNego;
	}
	
	
}
