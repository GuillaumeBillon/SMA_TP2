package run;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import utils.Catalogue;
import modele.Billet;
import modele.Negociateur;
import modele.Service;

public class Main {
	
	public static void main(String[] args){
		
		// CREATION DES BILLETS
		Billet b1 = new Billet(new Date(10,11,2016), new Date(10,11,2016), "Paris", "Moscou", (float) 120, "SNCF");
		
		Service service = new Service();
		service.getListeBillets().add(b1);
		
		// CREATION DES NEGOCIATEURS
		Negociateur n1 = new Negociateur(null, "Paris", "Moscou", (float) 500, new Date(1,11,2016), Catalogue.getListeCompagnies(), new ArrayList<String>());
		
		// CREATION DES FOURNISSEURS
	}
}
