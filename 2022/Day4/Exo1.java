package Day4;

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
	    		int virgule = ligne.indexOf(",");
	    		String part1 = ligne.substring(0, virgule);
	    		String part2 = ligne.substring(virgule+1);
	    		String[] parts1 = part1.split("-");
	    		String[] parts2 = part2.split("-");
	    		int min1 = Integer.parseInt(parts1[0]);
	    		int max1 = Integer.parseInt(parts1[1]);
	    		int min2 = Integer.parseInt(parts2[0]);
	    		int max2 = Integer.parseInt(parts2[1]);
	    		
	    		if (min1 >= min2 && min1 <= max2 && max1 >= min2 && max1 <= max2)
	    			somme += 1;
	    		else if (min2 >= min1 && min2 <= max1 && max2 >= min1 && max2 <= max1)
	    			somme += 1;
	    		
	    	}
	    	
	    	System.out.println(somme);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
