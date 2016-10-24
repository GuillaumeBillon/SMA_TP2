package modele;

import java.util.List;

import utils.Act;

public class Fournisseur extends Agent {
	// ATTRIBUTS
	List<Negociateur> listeNego;
	Service service;
	Long freqSoummission;
	int pourcentageAugmentation;
	
	// CONSTRUCTEURS
	public Fournisseur() {
		
	}
	
	public Fournisseur(String nom, List<Negociateur> listeNego, Service service, long freqSoummission, int pourcentageAugmentation) {
		this.nom = nom;
		this.listeNego = listeNego;
		this.service = service;
		this.freqSoummission = freqSoummission;
		this.pourcentageAugmentation = pourcentageAugmentation;
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
							if(null != service.testFounisseurPossedeDestinationDeNegociateur(n)){
								Float prixMin = service.testFounisseurPossedeDestinationDeNegociateur(n).getPrixMin();
								Float prixPropose = prixMin + (prixMin * pourcentageAugmentation / 100);
								// Création et envoie de l'offre
								Message msgPropose = new Message(this, n, Act.PROPOSE, prixPropose, 1);
								n.boiteAuxLettres.getBoite().add(msgPropose);
							}	
							m.setLu(true);
						}
						else if(m.getAct().equalsIgnoreCase(Act.CONTRE_PROPOSITION)){
							Negociateur n = (Negociateur) m.getEmetteur();
							Float prixMin = service.testFounisseurPossedeDestinationDeNegociateur(n).getPrixMin();
							Float prixPropose = prixMin + (prixMin * pourcentageAugmentation / 100);
							// On attend que le temps de la fréquence de soussission passe
							try {
								Thread.sleep(freqSoummission);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// Si on a fait moins de 6 propositions
							if(m.getNumeroOffre() < 6){
								// Création d'une nouvelle offre
								Float nouvelleProposition = (prixPropose - (prixPropose * (10 * m.getNumeroOffre())/100));
								if(nouvelleProposition < prixMin){
									nouvelleProposition = prixMin;
								}
								if(nouvelleProposition < m.getProposition()){
									nouvelleProposition = m.getProposition();
								}
								Message msgPropose = new Message(this, n, Act.PROPOSE, nouvelleProposition, m.getNumeroOffre() + 1);
								n.boiteAuxLettres.getBoite().add(msgPropose);
							}
							m.setLu(true);
						}
						else if(m.getAct().equalsIgnoreCase(Act.REFUS)){
							
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

	public Long getFreqSoummission() {
		return freqSoummission;
	}

	public void setFreqSoummission(Long freqSoummission) {
		this.freqSoummission = freqSoummission;
	}

	public int getPourcentageAugmentation() {
		return pourcentageAugmentation;
	}

	public void setPourcentageAugmentation(int pourcentageAugmentation) {
		this.pourcentageAugmentation = pourcentageAugmentation;
	}
	
	
}
