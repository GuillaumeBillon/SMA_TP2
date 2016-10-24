package run;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import utils.Catalogue;
import modele.Billet;
import modele.Fournisseur;
import modele.Negociateur;
import modele.Service;

public class Main {
	
	public static void main(String[] args){
		
		// CREATION DES BILLETS
		Billet b1 = new Billet(new Date(10,11,2016), new Date(10,11,2016), "Paris", "Moscou", (float) 400, "SNCF");
		
		Service service = new Service(new ArrayList<Billet>());
		service.getListeBillets().add(b1);
		
		// CREATION DES NEGOCIATEURS
		Negociateur n1 = new Negociateur("Michel",null, "Paris", "Moscou", (float) 500, new Date(1,11,2016), Catalogue.getListeCompagnies(), new ArrayList<String>());
		List<Negociateur> listeNego = new ArrayList<Negociateur>();
		listeNego.add(n1);
		
		// CREATION DES FOURNISSEURS
		Fournisseur f1 = new Fournisseur("Robert Négo", listeNego, service, 1000, 100);
		Fournisseur f2 = new Fournisseur("Olivier Négo", listeNego, service, 1000, 200);
		Fournisseur f3 = new Fournisseur("José Négo", listeNego, service, 1100, 101);
		List<Fournisseur> listeFourni = new ArrayList<Fournisseur>();
		listeFourni.add(f1);
		listeFourni.add(f2);
		listeFourni.add(f3);
		
		// Mise à jour de la liste de fournisseurs pour les négociateurs
		n1.setListFourni(listeFourni);
		
		// DEMARRAGE DES THREADS
		for(int i = 0; i < listeFourni.size(); i++){
			listeFourni.get(i).start();
		}
		for(int i = 0; i < listeNego.size(); i++){
			listeNego.get(i).start();
		}
	}
}
