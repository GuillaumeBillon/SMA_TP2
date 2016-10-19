package modele;

import java.util.Date;

public class Billet {
	
	Date dateDepart;
	Date dateArrivee;
	String lieuDepart;
	String lieuArrive;
	Float prixMin;
	String compagnie;
	
	public Billet(){
		
	}
	
	public Billet(Date dateDepart, Date dateArrivee, String lieuDepart, String lieuArrive, Float prixMin, String compagnie){
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.lieuDepart = lieuDepart;
		this.lieuArrive = lieuArrive;
		this.prixMin = prixMin;
		this.compagnie = compagnie;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	
	public String getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public String getLieuArrive() {
		return lieuArrive;
	}

	public void setLieuArrive(String lieuArrive) {
		this.lieuArrive = lieuArrive;
	}

	public Float getPrixMin() {
		return prixMin;
	}

	public void setPrixMin(Float prixMin) {
		this.prixMin = prixMin;
	}

	public String getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}	
}
