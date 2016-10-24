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
	int numeroOffre;
	
	// CONSTRUCTEURS
	public Message(){
	}
	
	public Message(Agent emetteur, Agent recepteur, String act, Float proposition, int numeroOffre){
		this.emetteur = emetteur;
		this.recepteur = recepteur;
		this.lu = false;
		this.act = act;
		this.proposition = proposition;
		this.numeroOffre = numeroOffre;
		if(emetteur instanceof Negociateur){
			if(act.equalsIgnoreCase(Act.APPEL)){
				System.out.println("Negociateur "+ emetteur.getNom() +" : Envoi de "+ act);
			}
			else if(act.equalsIgnoreCase(Act.CONTRE_PROPOSITION)){
				System.out.println("Negociateur "+ emetteur.getNom() +" : Envoi de "+ act + " à "+ recepteur.getNom() + " pour "+ proposition +"€");
			}
			else if(act.equalsIgnoreCase(Act.ACCEPTATION)){
				System.out.println("Negociateur "+ emetteur.getNom() +" : Envoi de "+ act + " à "+ recepteur.getNom() + " pour "+ proposition +"€");
			}
		}
		else {
			System.out.println("Fournisseur "+ emetteur.getNom() +" : Envoi de "+ act + " à "+ recepteur.getNom() + " pour "+ proposition +"€");
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

	public int getNumeroOffre() {
		return numeroOffre;
	}

	public void setNumeroOffre(int numeroOffre) {
		this.numeroOffre = numeroOffre;
	}
	
}
