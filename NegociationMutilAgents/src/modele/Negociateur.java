package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.Act;

public class Negociateur extends Agent {
	// ATTRIBUTS
	List<Fournisseur> listFourni;
	String depart;
	String destination;
	Float budget;
	Date dateLimiteAchat;
	List<String> compagnieAcceptee;
	List<String> compagnieRefusee;
	Float derniereOffre;
	
	// CONSTRUCTEURS
	public Negociateur() {

	}
	
	public Negociateur(String nom, List<Fournisseur> listFourni, String depart, String destination, Float budget, Date dateLimiteAchat, List<String> compagnieAcceptee, List<String> compagnieRefusee){
		this.nom = nom;
		this.listFourni = listFourni;
		this.depart = depart;
		this.destination = destination;
		this.budget = budget;
		this.dateLimiteAchat = dateLimiteAchat;
		this.compagnieAcceptee = compagnieAcceptee;
		this.compagnieRefusee = compagnieRefusee;
		this.derniereOffre = (float) 0;
	}
	
	public void run(){
		boolean offreAccepte = false;
		
		// Envoie de l'appel d'offre à  tous les fournisseurs
		for(int i = 0; i <  listFourni.size(); i++){
			Message msgAppel = new Message(this, null, Act.APPEL, null, 0);
			listFourni.get(i).getBoiteAuxLettres().getBoite().add(msgAppel);
		}
		
		// Tant que le négociateur n'a pas trouvé d'offre satisfaisante
		while(!offreAccepte){
			// Attente pour recevoir les différentes offres
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// On regarde si on a reçu des messages
			if(boiteAuxLettres.messageNonLu()){
				List<Message> listeMsgPropose = new ArrayList<Message>();
				// Récupération de tous les messages non lus
				for(Message m : boiteAuxLettres.getBoite()){
					if(!m.isLu()){
						// Si le message est une PROPOSE
						if(m.getAct().equalsIgnoreCase(Act.PROPOSE)){
							listeMsgPropose.add(m);
							m.setLu(true);
						}
					}
				}
				// Réponse à toutes les propositions
				Float meilleurProposition = (float) 0;
				Fournisseur meilleurFournisseur = null;
				int numeroMeilleur = 0;
				for(int i = 0; i < listeMsgPropose.size(); i++){
					Message m = listeMsgPropose.get(i);
					Fournisseur f = (Fournisseur) m.getEmetteur();
					if(i == 0){
						meilleurProposition = m.getProposition();
						meilleurFournisseur = (Fournisseur) m.getEmetteur();
						numeroMeilleur = m.getNumeroOffre();
					}
					else if(meilleurProposition > m.getProposition()){
						// Envoie d'un message de refus pour le fournisseur qui propose une offre moins intéressante
						Message msgRefus = new Message(this, meilleurFournisseur, Act.REFUS, meilleurProposition, numeroMeilleur);
						meilleurFournisseur.getBoiteAuxLettres().getBoite().add(msgRefus);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						meilleurProposition = m.getProposition();
						meilleurFournisseur = (Fournisseur) m.getEmetteur();
						numeroMeilleur = m.getNumeroOffre();
					}
				}
				// Envoie de la contre-proposition ou de l'acceptation au meilleur fournisseur
				if(meilleurProposition <= (budget - (budget * 50/100)) ||  derniereOffre >= meilleurProposition){
					Message msgAcceptation = new Message(this, meilleurFournisseur, Act.ACCEPTATION, meilleurProposition, numeroMeilleur);
					meilleurFournisseur.getBoiteAuxLettres().getBoite().add(msgAcceptation);
					offreAccepte = true;
				}
				else {
					derniereOffre = (budget - (budget * (6 - numeroMeilleur)/10));
					Message msgContreProp = new Message(this, meilleurFournisseur, Act.CONTRE_PROPOSITION, derniereOffre, numeroMeilleur);
					meilleurFournisseur.getBoiteAuxLettres().getBoite().add(msgContreProp);
				}
			}
			else {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// METHODES
	public List<Fournisseur> getListFourni() {
		return listFourni;
	}

	public void setListFourni(List<Fournisseur> listFourni) {
		this.listFourni = listFourni;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Float getBudget() {
		return budget;
	}

	public void setBudget(Float budget) {
		this.budget = budget;
	}

	public Date getDateLimiteAchat() {
		return dateLimiteAchat;
	}

	public void setDateLimiteAchat(Date dateLimiteAchat) {
		this.dateLimiteAchat = dateLimiteAchat;
	}

	public List<String> getCompagnieAcceptee() {
		return compagnieAcceptee;
	}

	public void setCompagnieAcceptee(List<String> compagnieAcceptee) {
		this.compagnieAcceptee = compagnieAcceptee;
	}

	public List<String> getCompagnieRefusee() {
		return compagnieRefusee;
	}

	public void setCompagnieRefusee(List<String> compagnieRefusee) {
		this.compagnieRefusee = compagnieRefusee;
	}
	
	
}
