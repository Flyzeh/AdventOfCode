package Day1;

import java.io.BufferedReader;
import java.util.Collections;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Exo2 {
	
	public static void main(String[] args) {
		String cheminFichier = "your file";

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
	    	String ligne;
	    	int somme = 0;
	    	ArrayList<Integer> liste = new ArrayList<>();
	    	
	    	while ((ligne = bufferedReader.readLine()) != null) {
	    		if (!ligne.isEmpty())  {
	    			somme += Integer.parseInt(ligne);
	    		}
	    		else {
	    			liste.add(somme);
	    			somme = 0;
	    		}
	    		
	    	}
	    	if (somme > 0) {
	    		liste.add(somme);
	    	}
	    	Collections.sort(liste, Collections.reverseOrder());
	    	System.out.println(liste.get(0) + liste.get(1) + liste.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
