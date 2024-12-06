public class Part2 {

    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input6.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int result = 0;
            int ind = 0;
            char tab[][] = new char[130][130];
            int depx = 0;
            int depy = 0;


            while ((ligne = bufferedReader.readLine()) != null) {

                for (int i = 0; i < ligne.length(); i++) {
                    tab[i][ind] = ligne.charAt(i);
                    if (tab[i][ind] != '.' &&  tab[i][ind] != '#') {
                        depx = i;
                        depy = ind;
                    }
                }
                ind++;
            }


            for (int x = 0; x < 130; x++) {
                for (int y = 0; y < 130; y++) {
                    if (tab[x][y] == '.' && (x != depx || y != depy)) {
                        tab[x][y] = 'O';

                        if (infini(tab, depx, depy)) {
                            result++;
                        }

                        tab[x][y] = '.';
                    }
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean infini(char[][] tab, int depx, int depy) {
        int mvtx = 0, mvty = -1;
        int result = 0;
        String sens = "haut";

        while (depx >= 0 && depy >= 0 && depx < 130 && depy < 130) {

            if (depx+mvtx < 0 || depy+mvty < 0 || depx+mvtx >= 130 || depy+mvty >= 130) {
                return false;
            }
            if (result > 6000) {
                return true;
            }

            if (tab[depx + mvtx][depy + mvty] == '#' || tab[depx + mvtx][depy + mvty] == 'O') {
                if (sens.equals("haut")) {
                    sens = "droite";
                    mvtx = 1;
                    mvty = 0;
                } else if (sens.equals("droite")) {
                    sens = "bas";
                    mvtx = 0;
                    mvty = 1;
                } else if (sens.equals("bas")) {
                    sens = "gauche";
                    mvtx = -1;
                    mvty = 0;
                } else if (sens.equals("gauche")) {
                    sens = "haut";
                    mvtx = 0;
                    mvty = -1;
                }
            }
            else {
                result++;
                depx += mvtx;
                depy += mvty;

            }
        }
        return false;
    }
}
