package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exo2 {
	
	public static void main(String[] args) {
		String cheminFichier = "your file";

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
	    	String ligne;
	    	int somme = 0;
	    	int i = 0;
	    	ArrayList<String> liste = new ArrayList<>();
	    	
	    	while ((ligne = bufferedReader.readLine()) != null) {	
	    		liste.add(ligne);
	    		i++;
	    		boolean stop = false;
	    		if (i == 3) {
	    			for (int j = 0; j < liste.get(0).length(); j++) {
	    				for (int z = 0; z < liste.get(1).length(); z++) {
	    					if (liste.get(0).charAt(j) == liste.get(1).charAt(z)) {
	    						for (int k = 0; k < liste.get(2).length(); k++) {
	    							if (liste.get(0).charAt(j) == liste.get(2).charAt(k)) {
	    								if (Character.isUpperCase(liste.get(0).charAt(j)))
	    		    						somme += (int) liste.get(0).charAt(j) - 38;
	    		    					else
	    		    						somme += (int) liste.get(0).charAt(j) - 96;
	    								stop = true;
	    								break;
	    							}
	    							
	    						}
	    						
	    					}
	    					if (stop) break;
	    				}
	    				if (stop) break;
	    			}
	    			liste.clear();
	    			i = 0;
	    		}
	    	}
	    	
	    	System.out.println(somme);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
