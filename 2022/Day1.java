package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
	
	public static void main(String[] args) {
		String cheminFichier = "your file";

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
	    	String ligne;
	    	int max_somme = 0;
	    	int somme = 0;
	    	
	    	while ((ligne = bufferedReader.readLine()) != null) {
	    		if (!ligne.isEmpty())  {
	    			somme += Integer.parseInt(ligne);
	    		}
	    		else {
	    			if (somme > max_somme)
			    		max_somme = somme;
	    			somme = 0;
	    		}
	    	}
	    	
	    	System.out.println(max_somme);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
