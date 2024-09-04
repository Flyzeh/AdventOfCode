package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exo1 {
	
	public static void main(String[] args) {
		String cheminFichier = "your file";

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
	    	String ligne;
	    	int somme = 0;
	    	while ((ligne = bufferedReader.readLine()) != null) {
	    		int milieu = ligne.length() / 2;
	    		boolean stop = false;
	    		String part1 = ligne.substring(0, milieu);
	    		String part2 = ligne.substring(milieu);
	    		for (int i = 0; i < part1.length(); i++) {
	    			for (int j = 0; j < part2.length(); j++) {
	    				if (part1.charAt(i) == part2.charAt(j)) {
	    					if (Character.isUpperCase(part1.charAt(i)))
	    						somme += (int) part1.charAt(i) - 38;
	    					else
	    						somme += (int) part1.charAt(i) - 96;
	    					stop = true;
	    					
	    				}
	    				if (stop == true)
	    					break;
	    			}
	    			if (stop == true)
	    					break;
	    		} 	
	    	}
	    	
	    	System.out.println(somme);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}

