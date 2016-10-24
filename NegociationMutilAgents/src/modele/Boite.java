package modele;

import java.util.LinkedList;

public class Boite {
	// ATTRIBUTS
	LinkedList<Message> boite = new LinkedList<Message>();
	
	// CONSTRUCTEURS
	public Boite(){
	}
	
	public Boite(LinkedList<Message> boite){
		this.boite = boite;
	}
	
	// METHODES
	public boolean messageNonLu(){
		for(Message m : boite){
			if(!m.isLu()){
				return true;
			}
		}
		return false;
	}
	
	public LinkedList<Message> getBoite() {
		return boite;
	}

	public void setBoite(LinkedList<Message> boite) {
		this.boite = boite;
	}
}
