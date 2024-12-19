public class Part1 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/test";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            List<String> serviettes = new ArrayList<>();
            List<String> prod = new ArrayList<>();
            int ind = 0;
            int resultat = 0;

            while ((ligne = bufferedReader.readLine()) != null) {
                if (ligne.equals("")) continue;
                if (ind == 0) {
                    String[] parts = ligne.replaceAll("\\s+", "").split(",");
                    for (int i = 0; i < parts.length; i++) {
                        serviettes.add(parts[i]);
                    }
                }
                else {
                    prod.add(ligne);
                }
                ind++;
            }
            List<String> prod2 = new ArrayList<>(prod);
            System.out.println(prod.size());
            
            Collections.sort(serviettes, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
            for (int i = 0; i < prod.size(); i++) {
                String copy = prod.get(i);
                for (int j = 0; j < serviettes.size(); j++) {
                    if (prod.get(i).contains(serviettes.get(j))){
                        String updatedProd = prod.get(i).replace(serviettes.get(j), "");
            
                        prod.set(i, updatedProd);
            
                        if (!updatedProd.matches("[^a-zA-Z]*")) {
                            resultat++;
                            for (int k = 0; k < prod2.size(); k++) {
                                if (prod2.get(k).equals(copy))
                                    prod2.remove(k);
                            }
                        }
                    }
                }
            }
            System.out.println(resultat);
            System.out.println("/");


            

            System.out.println(prod2.size());
            List<String> prod3 = new ArrayList<>(prod2);
            Collections.sort(serviettes, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
            for (int i = 0; i < prod2.size(); i++) {
                String copy = prod2.get(i);
                for (int j = 0; j < serviettes.size(); j++) {
                    if (prod2.get(i).contains(serviettes.get(j))){
                        String updatedProd = prod2.get(i).replace(serviettes.get(j), " ");
            
                        prod2.set(i, updatedProd);
            
                        if (updatedProd.isEmpty()) {
                            resultat++;
                            for (int k = 0; k < prod3.size(); k++) {
                                if (prod3.get(k).equals(copy))
                                    prod3.remove(k);
                            }
                        }
                    }
                }
            }
            System.out.println(prod.size() - prod3.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
}
