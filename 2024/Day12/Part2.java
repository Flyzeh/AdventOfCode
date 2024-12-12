public class Part2 {
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
                        Set<String> region = new HashSet<>();
                        int aire = 0;
                        int coins = 0;
                        
                        aire = calculaire(carte, i, j, point, visite, region, aire);

                        for (String k : region) {
                            String[] parts = k.split(",");
                            int x = Integer.parseInt(parts[0]);
                            int y = Integer.parseInt(parts[1]);

                            coins += calculcoins(carte, x, y, region);
                        }

                        result += aire * coins;
                    }
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int calculaire(char[][] carte, int x, int y, char point, Set<String> visite, Set<String> region, int aire) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        ArrayList<int[]> pile = new ArrayList<>();
        pile.add(new int[]{x, y});
        visite.add(x + "," + y);
        region.add(x + "," + y);
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
                        region.add(newx + "," + newy);
                        aire++;
                    }
                }
            }
        }

        return aire;
    }


    private static int calculcoins(char[][] carte, int x, int y, Set<String> region) {
        int coins = 0;

        if (!region.contains((x - 1) + "," + y) && !region.contains(x + "," + (y - 1))) coins++;
        if (!region.contains((x + 1) + "," + y) && !region.contains(x + "," + (y - 1))) coins++;
        if (!region.contains((x - 1) + "," + y) && !region.contains(x + "," + (y + 1))) coins++;
        if (!region.contains((x + 1) + "," + y) && !region.contains(x + "," + (y + 1))) coins++;

        if (region.contains((x - 1) + "," + y) && region.contains(x + "," + (y - 1)) && !region.contains((x - 1) + "," + (y - 1))) coins++;
        if (region.contains((x + 1) + "," + y) && region.contains(x + "," + (y - 1)) && !region.contains((x + 1) + "," + (y - 1))) coins++;
        if (region.contains((x - 1) + "," + y) && region.contains(x + "," + (y + 1)) && !region.contains((x - 1) + "," + (y + 1))) coins++;
        if (region.contains((x + 1) + "," + y) && region.contains(x + "," + (y + 1)) && !region.contains((x + 1) + "," + (y + 1))) coins++;

        return coins;
    }
}
