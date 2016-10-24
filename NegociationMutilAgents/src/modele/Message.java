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
	Float proposition;
	
	// CONSTRUCTEURS
	public Message(){
	}
	
	public Message(Agent emetteur, Agent recepteur, String act, Float proposition){
		this.emetteur = emetteur;
		this.recepteur = recepteur;
		this.lu = false;
		this.act = act;
		this.proposition = proposition;
		if(emetteur instanceof Negociateur){
			System.out.println("Negociateur "+ emetteur.getNom() +" : Envoi de "+ act);
		}
		else {
			System.out.println("Fournisseur "+ emetteur.getNom() +" : Envoi de "+ act + " à "+ recepteur.getNom());
		}
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

	public Float getProposition() {
		return proposition;
	}

	public void setProposition(Float proposition) {
		this.proposition = proposition;
	}
	
}
