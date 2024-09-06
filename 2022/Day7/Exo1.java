package Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exo1 {
	
	
	public static abstract class Noeud {
	    public Dossier parent;  
	    public String nom;      

	    public abstract long getTaille();
	}

	public static class Fichier extends Noeud {
	    public int size;  

	    @Override
	    public long getTaille() {
	        return size;
	    }
	}

	public static class Dossier extends Noeud {
	    public List<Noeud> contenu = new ArrayList<>();  

	    public List<Dossier> getsous_Fichier() {
	        List<Dossier> sous_fichier = new ArrayList<>();
	        for (Noeud n : contenu) {
	            if (n instanceof Dossier) {
	                sous_fichier.add((Dossier) n);  
	            }
	        }
	        return sous_fichier;
	    }

	    @Override
	    public long getTaille() {
	        long size = 0;
	        for (Noeud n : contenu) {
	            size += n.getTaille(); 
	        }
	        return size;
	    }
	    
	    public long sommeTaille() {
	    	long somme = 0;

	        long tailleDossier = this.getTaille();
	        if (tailleDossier < 100000) {
	            somme += tailleDossier;
	        }

	        for (Noeud n : contenu) {
	            if (n instanceof Dossier) {
	                somme += ((Dossier) n).sommeTaille();
	            }
	        }

	        return somme; 
	}
	}
	 	
	public static void main(String[] args) {
		String cheminFichier = "your file";

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
	    	String ligne;
	    	
	    	Dossier racine = new Dossier();
	    	racine.nom = "/";
	    	Dossier dossier_recent = racine;
	    		    	
            
            while ((ligne = bufferedReader.readLine()) != null) {
               
            	String[] parts = ligne.split(" ");

    			if(parts[0].equals("$")) {
    			
    				if(parts[1].equals("cd")) {
    				
    					if(parts[2].equals("..")) {
    					
    						dossier_recent = dossier_recent.parent;
    					}
    					else {
    					
    						for(Noeud n : dossier_recent.contenu) {
    						
    							if(n.nom.equals(parts[2])) {
    							
    								dossier_recent = (Dossier) n; 
    								break;
    							}
    						}
    					}
    				}
    			}
    			
    			else if(parts[0].equals("dir")) {
    			
    				Dossier dossier = new Dossier();
    				dossier.parent = dossier_recent;
    				dossier.nom = parts[1];
    				dossier_recent.contenu.add(dossier);
    			}
    			
    			else {
    			
    				Fichier fichier = new Fichier();
    				fichier.parent = dossier_recent;
    				fichier.nom = parts[1];
    				fichier.size = Integer.parseInt(parts[0]);
    				dossier_recent.contenu.add(fichier);
    			}
            }
            System.out.println(racine.sommeTaille());
	    	
	    	
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	}
}
