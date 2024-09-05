package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Exo2 {
	
	public static void main(String[] args) {
		String cheminFichier = "your file";

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
	    	String ligne;
	    	int somme = 0;
            
            while ((ligne = bufferedReader.readLine()) != null) {
                for (int i = 0; i <= ligne.length() - 14; i++) {
                    HashSet<Character> liste_unique = new HashSet<>();

                    for (int j = i; j < i + 14; j++) {
                        liste_unique.add(ligne.charAt(j));
                        if (j == i+13)
                        	somme = j+1;
                    }

                    if (liste_unique.size() == 14) {
                    	System.out.println(somme);
                    	break;
                    }
                }
            }
	    	
	    	

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
