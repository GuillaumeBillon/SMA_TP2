package modele;

import java.util.List;

public class Service {
	// ATTRIBUTS
	List<Billet> listeBillets;
	
	// CONSTRUCTEURS
	public Service() {
	}
	
	public Service(List<Billet> listeBillets){
		this.listeBillets = listeBillets;
	}

	// METHODES
	public List<Billet> getListeBillets() {
		return listeBillets;
	}

	public void setListeBillets(List<Billet> listeBillets) {
		this.listeBillets = listeBillets;
	}
	
}
