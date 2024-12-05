public class Part2 {

    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input2.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int result = 0;

            while ((ligne = bufferedReader.readLine()) != null) {
                String[] parts = ligne.split(" ");
                List<Integer> niveaux = new ArrayList<>();
                for (String part : parts) {
                    niveaux.add(Integer.parseInt(part));
                }

                if (Good(niveaux)) {
                    result++;
                } else if (NewGood(niveaux)) {
                    result++;
                }
            }

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean Good(List<Integer> niveaux) {
        boolean croissant = niveaux.get(0) < niveaux.get(1);

        for (int i = 1; i < niveaux.size(); i++) {
            int diff = Math.abs(niveaux.get(i) - niveaux.get(i - 1));
            if (diff < 1 || diff > 3) {
                return false;
            }
            if (croissant && niveaux.get(i) < niveaux.get(i - 1)) {
                return false;
            }
            if (!croissant && niveaux.get(i) > niveaux.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean NewGood(List<Integer> niveaux) {
        for (int i = 0; i < niveaux.size(); i++) {
            List<Integer> newniveaux = new ArrayList<>(niveaux);
            newniveaux.remove(i);

            if (Good(newniveaux)) {
                return true;
            }
        }
        return false;
    }
}
