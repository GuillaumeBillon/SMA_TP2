package modele;

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
	
	// CONSTRUCTEURS
	public Negociateur() {

	}
	
	public Negociateur(List<Fournisseur> listFourni, String depart, String destination, Float budget, Date dateLimiteAchat, List<String> compagnieAcceptee, List<String> compagnieRefusee){
		this.listFourni = listFourni;
		this.depart = depart;
		this.destination = destination;
		this.budget = budget;
		this.dateLimiteAchat = dateLimiteAchat;
		this.compagnieAcceptee = compagnieAcceptee;
		this.compagnieRefusee = compagnieRefusee;
	}
	
	public void run(){
		boolean offreAccepte = false;
		
		// Envoie de l'appel d'offre à  tous les fournisseurs
		Message msgAppel = new Message(this, null, Act.APPEL);
		for(int i = 0; i <  listFourni.size(); i++){
			listFourni.get(i).getBoiteAuxLettres().getBoite().add(msgAppel);
		}
		
		// Tant que le négociateur n'a pas trouvé d'offre satisfaisante
		while(!offreAccepte){
			// On regarde si on a reçu des messages
			if(boiteAuxLettres.messageNonLu()){
				
			}
			else {
				try {
					Thread.sleep(1000);
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
