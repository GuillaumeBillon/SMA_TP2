package modele;

import java.util.List;

import utils.Act;

public class Fournisseur extends Agent {
	// ATTRIBUTS
	List<Negociateur> listeNego;
	Service service;
	Float prixDepart;
	Long freqSoummission;
	
	// CONSTRUCTEURS
	public Fournisseur() {
		
	}
	
	public Fournisseur(String nom, List<Negociateur> listeNego, Service service, Float prixDepart, long freqSoummission) {
		this.nom = nom;
		this.listeNego = listeNego;
		this.service = service;
		this.prixDepart = prixDepart;
		this.freqSoummission = freqSoummission;
	}
	
	// METHODES
	public void run(){
		while(true){
			if(boiteAuxLettres.messageNonLu()){
				for(Message m : boiteAuxLettres.getBoite()){
					if(!m.isLu()){
						// Si le message est un APPEL
						if(m.getAct().equalsIgnoreCase(Act.APPEL)){
							Negociateur n = (Negociateur) m.getEmetteur();
							// Test si on possède une offre pour le négociteur
							if(service.testFounisseurPossedeDestinationDeNegociateur(n)){
								// Création et envoie de l'offre
								Message msgPropose = new Message(this, n, Act.PROPOSE, prixDepart, 1);
								n.boiteAuxLettres.getBoite().add(msgPropose);
							}	
							m.setLu(true);
						}
						if(m.getAct().equalsIgnoreCase(Act.CONTRE_PROPOSITION)){
							Negociateur n = (Negociateur) m.getEmetteur();
							// On attend que le temps de la fréquence de soussission passe
							try {
								Thread.sleep(freqSoummission);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// Si on a fait moins de 6 propositions
							if(m.getNumeroOffre() < 6){
								// Création d'une nouvelle offre
								float nouvelleProposition = (prixDepart - (prixDepart * (10 * m.getNumeroOffre())/100));
								if(nouvelleProposition < m.getProposition()){
									nouvelleProposition = m.getProposition();
								}
								Message msgPropose = new Message(this, n, Act.PROPOSE, nouvelleProposition, m.getNumeroOffre() + 1);
								n.boiteAuxLettres.getBoite().add(msgPropose);
							}
							m.setLu(true);
						}
					}
				}
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
	
	public List<Negociateur> getListeNego() {
		return listeNego;
	}

	public void setListeNego(List<Negociateur> listeNego) {
		this.listeNego = listeNego;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Float getPrixDepart() {
		return prixDepart;
	}

	public void setPrixDepart(Float prixDepart) {
		this.prixDepart = prixDepart;
	}

	public Long getFreqSoummission() {
		return freqSoummission;
	}

	public void setFreqSoummission(Long freqSoummission) {
		this.freqSoummission = freqSoummission;
	}
	
	
}
