package modele;

import java.util.Date;
import java.util.List;

public class Negociateur extends Agent {
	List<Fournisseur> listFourni;
	String depart;
	String destination;
	Float budget;
	Date dateLimiteAchat;
	List<String> compagnieAcceptee;
	List<String> compagnieRefusee;
	
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
		
	}

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
