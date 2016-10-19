package utils;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {

	public static List<String> getListeCompagnies(){
		List<String> listeCompagnies = new ArrayList<String>();
		listeCompagnies.add("SNCF");
		listeCompagnies.add("Le train de l'ambiance");
		listeCompagnies.add("Train S");
		
		return listeCompagnies;
	}
}
