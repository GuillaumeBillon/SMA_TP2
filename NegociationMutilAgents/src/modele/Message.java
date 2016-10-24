package modele;


import utils.Act;
import utils.Performatif;

public class Message {
	// ATTRIBUTS
	Agent emetteur;
	Agent recepteur;
	String performatif = Performatif.REQUEST;
	String act;
	boolean lu;
	
	// CONSTRUCTEURS
	public Message(){
	}
	
	public Message(Agent emetteur, Agent recepteur, String act){
		this.emetteur = emetteur;
		this.recepteur = recepteur;
		this.lu = false;
		this.act = act;
		System.out.println("Envoi de "+ act);
	}
	
	// METHODES
	public Agent getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Agent emetteur) {
		this.emetteur = emetteur;
	}

	public Agent getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(Agent recepteur) {
		this.recepteur = recepteur;
	}

	public String getPerformatif() {
		return performatif;
	}

	public void setPerformatif(String performatif) {
		this.performatif = performatif;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}
	
}
