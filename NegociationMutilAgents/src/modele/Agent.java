package modele;

public abstract class Agent extends Thread{
	
	String nom;
	Boite boiteAuxLettres = new Boite();
	
	public Agent(){
		
	}
	
	public Agent(String nom, Boite boiteAuxLettres){
		this.nom = nom;
		this.boiteAuxLettres = boiteAuxLettres;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boite getBoiteAuxLettres() {
		return boiteAuxLettres;
	}

	public void setBoiteAuxLettres(Boite boiteAuxLettres) {
		this.boiteAuxLettres = boiteAuxLettres;
	}
	
	
}
