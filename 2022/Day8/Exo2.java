package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exo2 {

	
	public static void main(String[] args) {
        String cheminFichier = "your file";

        List<int[]> listeLignes = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            
            while ((ligne = bufferedReader.readLine()) != null) {
                int[] ligneArbres = new int[ligne.length()];
                
                for (int i = 0; i < ligne.length(); i++) {
                    ligneArbres[i] = Character.getNumericValue(ligne.charAt(i));
                }
                
                listeLignes.add(ligneArbres);
                
            }
            
            int[][] arbres = new int[listeLignes.size()][];
            for (int i = 0; i < listeLignes.size(); i++) {
                arbres[i] = listeLignes.get(i);
            }
            
            System.out.println(MeilleurScore(arbres));

        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }

    
    public static int MeilleurScore (int[][] arbres) {
        int ligne = arbres.length;
        int colonne = arbres[0].length;
        int max = 0;


        for (int i = 1; i < ligne - 1; i++) {
            for (int j = 1; j < colonne - 1; j++) {
                if (Score(arbres, i, j) > max) {
                    max = Score(arbres, i, j);
                }
            }
        }

        return max;
    }

    public static int Score(int[][] arbres, int ligne, int colonne) {
        int taille = arbres[ligne][colonne];

        int gauche = 0;
        for (int j = colonne - 1; j >= 0; j--) {
        	gauche += 1;
            if (arbres[ligne][j] >= taille) {
                break;
            }
        }

        int droite = 0;
        for (int j = colonne + 1; j < arbres[0].length; j++) {
        	droite += 1;
            if (arbres[ligne][j] >= taille) {
                break;
            }
        }

        int haut = 0;
        for (int i = ligne - 1; i >= 0; i--) {
        	haut+= 1;
            if (arbres[i][colonne] >= taille) {
                break;
            }
        }

        int bas = 0;
        for (int i = ligne + 1; i < arbres.length; i++) {
        	bas += 1;
            if (arbres[i][colonne] >= taille) {
                break;
            }
        }
        
        return (gauche * droite * haut * bas);
    }
    
}
