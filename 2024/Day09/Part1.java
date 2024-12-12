public class Part1 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input9.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            long result = 0;
            ArrayList<String> list = new ArrayList<>();
            int fichier = 0;

            while ((ligne = bufferedReader.readLine()) != null) {
                for (int i = 0; i < ligne.length(); i++) {
                    if (i % 2 == 0) {
                        for (int j = 0; j < Character.getNumericValue(ligne.charAt(i)); j++) {
                            list.add(String.valueOf(fichier));
                        }
                        fichier++;
                    }
                    else {
                        for (int j = 0; j < Character.getNumericValue(ligne.charAt(i)); j++) {
                            list.add(".");
                        }
                    }
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(".")) {
                    while (list.getLast().equals(".")) {
                        list.removeLast();
                    }
                    list.set(i, list.getLast());
                    list.removeLast();
                }

                result += i * Long.parseLong(list.get(i));
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
