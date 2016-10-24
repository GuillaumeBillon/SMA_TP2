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
	public Billet testFounisseurPossedeDestinationDeNegociateur(Negociateur n){
		for(int i = 0; i < listeBillets.size(); i++){
			if(listeBillets.get(i).getLieuDepart().equalsIgnoreCase(n.getDepart())
					&& listeBillets.get(i).getLieuArrive().equalsIgnoreCase(n.getDestination())){
				return listeBillets.get(i);
			}
		}		
		return null;
	}
	
	public List<Billet> getListeBillets() {
		return listeBillets;
	}

	public void setListeBillets(List<Billet> listeBillets) {
		this.listeBillets = listeBillets;
	}
	
}
