package modele;

import java.util.Date;

public class Billet {
	
	Date dateDepart;
	Date dateArrivee;
	String lieuxArrive;
	Float prixMin;
	
	public Billet(){
		
	}
	
	public Billet(Date dateDepart, Date dateArrivee, String lieuxArrive, Float prixMin){
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.lieuxArrive = lieuxArrive;
		this.prixMin = prixMin;
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

	public String getLieuxArrive() {
		return lieuxArrive;
	}

	public void setLieuxArrive(String lieuxArrive) {
		this.lieuxArrive = lieuxArrive;
	}

	public Float getPrixMin() {
		return prixMin;
	}

	public void setPrixMin(Float prixMin) {
		this.prixMin = prixMin;
	}
	
	
}
