public class Part1 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input12.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            char[][] carte = new char[140][140];
            int ind = 0;

            while ((ligne = bufferedReader.readLine()) != null) {

                for (int i = 0; i < ligne.length(); i++) {
                    carte[i][ind] = ligne.charAt(i);
                }
                ind++;
            }

            Set<String> visite = new HashSet<>();
            int result = 0;

            for (int i = 0; i < carte.length; i++) {
                for (int j = 0; j < carte[0].length; j++) {
                    if (!visite.contains(i + "," + j)) {
                        char point = carte[i][j];
                        int aire = 0;
                        int perimetre = 0;
                        int prix = calculPrix(carte, i, j, point, visite, aire, perimetre);
                        result += prix;
                    }
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int calculPrix(char[][] carte, int x, int y, char point, Set<String> visite, int aire, int perimetre) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        ArrayList<int[]> pile = new ArrayList<>();
        pile.add(new int[]{x, y});
        visite.add(x + "," + y);
        aire++;

        while (!pile.isEmpty()) {
            int[] current = pile.remove(pile.size() - 1);
            int posx = current[0];
            int posy = current[1];

            for (int i = 0; i < 4; i++) {
                int newx = posx + dx[i];
                int newy = posy + dy[i];

                if (newx >= 0 && newx < carte.length && newy >= 0 && newy < carte[0].length) {
                    if (carte[newx][newy] == point && !visite.contains(newx + "," + newy)) {
                        pile.add(new int[]{newx, newy});
                        visite.add(newx + "," + newy);
                        aire++;
                    } else if (carte[newx][newy] != point) {
                        perimetre++;
                    }
                } else {
                    perimetre++;
                }
            }
        }

        return aire * perimetre;
    }
}
