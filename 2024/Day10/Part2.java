public class Part2 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input10.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int result = 0;
            char[][] carte = new char[47][47];
            HashMap<String, Integer> zero = new HashMap<>();
            int ind = 0;

            while ((ligne = bufferedReader.readLine()) != null) {

                for (int i = 0; i < ligne.length(); i++) {
                    carte[i][ind] = ligne.charAt(i);
                    if (carte[i][ind] == '0') {

                        zero.put(i + "," + ind, 0);
                    }
                }
                ind++;

            }

            for (Map.Entry<String, Integer> entry : zero.entrySet()) {
                String key = entry.getKey();
                int x = Integer.parseInt(key.split(",")[0]);
                int y = Integer.parseInt(key.split(",")[1]);
                System.out.println(x + "," + y);
                ArrayList<Integer> somme = new ArrayList<>();
                Parcourir(carte, x, y, somme, 0);
                result += somme.size();

            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int Parcourir(char[][] carte, int x, int y, List<Integer> somme, int last) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < carte.length && y + dy[i] >= 0 && y + dy[i] < carte[0].length) {

                char lasts = (char) ('0' + last+1);
                if (carte[x + dx[i]][y + dy[i]] == '9' && carte[x][y] == '8') {
                    somme.add(1);
                }

                else if (carte[x + dx[i]][y + dy[i]] == lasts) {
                    Parcourir(carte, x + dx[i], y + dy[i], somme, carte[x + dx[i]][y + dy[i]]-'0');
                }

            }
        }
        return somme.size();
    }
}
