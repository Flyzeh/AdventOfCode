package Day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exo1 {

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
            
            System.out.println(Compter(arbres));

        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }

    
    public static int Compter(int[][] arbres) {
        int ligne = arbres.length;
        int colonne = arbres[0].length;
        int NbVisible = 0;

        NbVisible += 2 * (ligne + colonne) - 4; 

        for (int i = 1; i < ligne - 1; i++) {
            for (int j = 1; j < colonne - 1; j++) {
                if (estVisible(arbres, i, j)) {
                    NbVisible++;
                }
            }
        }

        return NbVisible;
    }

    public static boolean estVisible(int[][] arbres, int ligne, int colonne) {
        int taille = arbres[ligne][colonne];

        boolean gauche = true;
        for (int j = colonne - 1; j >= 0; j--) {
            if (arbres[ligne][j] >= taille) {
                gauche = false;
                break;
            }
        }

        boolean droite = true;
        for (int j = colonne + 1; j < arbres[0].length; j++) {
            if (arbres[ligne][j] >= taille) {
                droite = false;
                break;
            }
        }

        boolean haut = true;
        for (int i = ligne - 1; i >= 0; i--) {
            if (arbres[i][colonne] >= taille) {
                haut = false;
                break;
            }
        }

        boolean bas = true;
        for (int i = ligne + 1; i < arbres.length; i++) {
            if (arbres[i][colonne] >= taille) {
                bas = false;
                break;
            }
        }

        return gauche || droite || haut || bas;
    }
	
}

