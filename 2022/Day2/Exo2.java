package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exo2 {
	
	public static void main(String[] args) {
		String cheminFichier = "your file";

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
	    	String ligne;
	    	int somme = 0;
	    	
	    	while ((ligne = bufferedReader.readLine()) != null) {
	    		char joueur1 = ligne.charAt(0);
	    		char joueur2 = ligne.charAt(2);
	    		
	    		switch (joueur2) {
	    	    	case 'Y':
	    	    		if (joueur1 == 'A') 
	    	    			somme += 4;
	    	    		else if (joueur1 == 'B')
	    	    			somme += 5;
	    	    		else if (joueur1 == 'C')
	    	    			somme += 6;	
	    	    		break;
	    	    	case 'X':
	    	    		if (joueur1 == 'A') 
	    	    			somme += 3;
	    	    		else if (joueur1 == 'B')
	    	    			somme += 1;
	    	    		else if (joueur1 == 'C')
	    	    			somme += 2;
	    	    		break;
	    	    	case 'Z':
	    	    		if (joueur1 == 'A') 
	    	    			somme += 8;
	    	    		else if (joueur1 == 'B')
	    	    			somme += 9;
	    	    		else if (joueur1 == 'C')
	    	    			somme += 7;
	    	    		break;
	    	     		
	    		}
	    	}
	    	
	    	System.out.println(somme);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
