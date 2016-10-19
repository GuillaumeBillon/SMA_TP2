package modele;

import java.util.List;

public class Negociateur extends Agent {
	List<Fournisseur> listFourni;
	
	public Negociateur() {

	}
	
	public Negociateur(List<Fournisseur> listFourni){
		this.listFourni = listFourni;
	}

	public List<Fournisseur> getListFourni() {
		return listFourni;
	}

	public void setListFourni(List<Fournisseur> listFourni) {
		this.listFourni = listFourni;
	}
	
	
}
