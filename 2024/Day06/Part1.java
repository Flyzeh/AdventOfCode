public class Part1 {
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
                    if (tab[i][ind] != '.' && tab[i][ind] != '#') {
                        depx = i;
                        depy = ind;
                    }
                }
                ind++;
            }

            int mvtx = 0;
            int mvty = -1;
            String sens = "haut";


            while (depx >= 0 && depy >= 0 && depx < 130 && depy < 130) {

                if (depx+mvtx < 0 || depy+mvty < 0 || depx+mvty >= 130 || depy+mvty >= 130) {
                    break;
                }

                if (tab[depx + mvtx][depy + mvty] == '#') {
                    if (sens.equals("haut")) {
                        sens = "droite";
                        mvtx = 1;
                        mvty = 0;
                        System.out.println("cc");
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
                else if (tab[depx + mvtx][depy + mvty] == '.' || tab[depx + mvtx][depy + mvty] == 'P') {
                    if (tab[depx][depy] != 'P') {
                        tab[depx][depy] = 'P';
                        result++;
                    }
                    depx += mvtx;
                    depy += mvty;

                }
            }

            System.out.println(result+1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
