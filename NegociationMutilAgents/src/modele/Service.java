package modele;

import java.util.List;

public class Service {
	List<Billet> listeBillets;
	
	public Service() {
	}
	
	public Service(List<Billet> listeBillets){
		this.listeBillets = listeBillets;
	}

	public List<Billet> getListeBillets() {
		return listeBillets;
	}

	public void setListeBillets(List<Billet> listeBillets) {
		this.listeBillets = listeBillets;
	}
	
}
