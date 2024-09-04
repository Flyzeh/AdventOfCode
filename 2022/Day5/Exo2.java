package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exo2 {

	public static void main(String[] args) {
		String cheminFichier = "your file";

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
	    	String ligne;
	    	int i = 0;
	    	ArrayList<Character> tab1 = new ArrayList<>();
	        ArrayList<Character> tab2 = new ArrayList<>();
	        ArrayList<Character> tab3 = new ArrayList<>();
	        ArrayList<Character> tab4 = new ArrayList<>();
	        ArrayList<Character> tab5 = new ArrayList<>();
	        ArrayList<Character> tab6 = new ArrayList<>();
	        ArrayList<Character> tab7 = new ArrayList<>();
	        ArrayList<Character> tab8 = new ArrayList<>();
	        ArrayList<Character> tab9 = new ArrayList<>();

	        tab1.add('D');
	        tab1.add('T');
	        tab1.add('W');
	        tab1.add('N');
	        tab1.add('L');

	        tab2.add('H');
	        tab2.add('P');
	        tab2.add('C');

	        tab3.add('J');
	        tab3.add('M');
	        tab3.add('G');
	        tab3.add('D');
	        tab3.add('N');
	        tab3.add('H');
	        tab3.add('P');
	        tab3.add('W');

	        tab4.add('L');
	        tab4.add('Q');
	        tab4.add('T');
	        tab4.add('N');
	        tab4.add('S');
	        tab4.add('W');
	        tab4.add('C');

	        tab5.add('N');
	        tab5.add('C');
	        tab5.add('H');
	        tab5.add('P');

	        tab6.add('B');
	        tab6.add('Q');
	        tab6.add('W');
	        tab6.add('M');
	        tab6.add('D');
	        tab6.add('N');
	        tab6.add('H');
	        tab6.add('T');

	        tab7.add('L');
	        tab7.add('S');
	        tab7.add('G');
	        tab7.add('J');
	        tab7.add('R');
	        tab7.add('B');
	        tab7.add('M');

	        tab8.add('T');
	        tab8.add('R');
	        tab8.add('B');
	        tab8.add('V');
	        tab8.add('G');
	        tab8.add('W');
	        tab8.add('N');
	        tab8.add('Z');

	        tab9.add('L');
	        tab9.add('P');
	        tab9.add('N');
	        tab9.add('D');
	        tab9.add('G');
	        tab9.add('W');
	        

	        Map<String, ArrayList<Character>> tableau = new HashMap<>();
	        tableau.put("tab1", tab1);
	        tableau.put("tab2", tab2);
	        tableau.put("tab3", tab3);
	        tableau.put("tab4", tab4);
	        tableau.put("tab5", tab5);
	        tableau.put("tab6", tab6);
	        tableau.put("tab7", tab7);
	        tableau.put("tab8", tab8);
	        tableau.put("tab9", tab9);
	    	
	    	while ((ligne = bufferedReader.readLine()) != null) {
	    		i++;
	    		if (i > 10) {
	    			String parts[] = ligne.split(" ");
	    			int nb = Integer.parseInt(parts[1]);
	    			String from = "tab" + parts[3];
	    			String to = "tab" + parts[5];
	    			
	    			for (int j = 0; j < nb; j++) {
	    			tableau.get(to).add(0,tableau.get(from).get(nb-1-j));
	    			tableau.get(from).remove(nb-1-j);
	    			}
	    		}
	    		
	    	}
	    	
	    	String mot = tab1.get(0).toString() + tab2.get(0).toString() + tab3.get(0).toString() + tab4.get(0).toString() +
	    			tab5.get(0).toString() + tab6.get(0).toString() + tab7.get(0).toString() + tab8.get(0).toString() + tab9.get(0).toString();
	    	System.out.println(mot);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
