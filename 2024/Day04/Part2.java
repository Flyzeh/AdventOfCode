public class Part2 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input4.txt";
        int result = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            char[][] tab = new char[140][140];
            int ind = 0;
            while ((ligne = bufferedReader.readLine()) != null) {
                for (int i = 0; i < ligne.length(); i++) {
                    tab[i][ind] = ligne.charAt(i);
                }
                ind++;
            }
            for (int i = 1; i < 140; i++) {
                for (int j = 1; j < 140; j++) {
                    if (tab[i][j] == 'A') {
                        if (Check(tab, i, j))
                            result++;
                    }
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static boolean Check(char[][] tab, int x, int y) {

        if (x - 1 >= 0 && y - 1 >= 0 && x + 1 < tab.length && y + 1 < tab[x].length) {
            if (tab[x - 1][y - 1] == 'M' && tab[x - 1][y + 1] == 'M' && tab[x + 1][y - 1] == 'S' && tab[x + 1][y + 1] == 'S') {
                return true;
            }
            else if (tab[x - 1][y - 1] == 'M' && tab[x - 1][y + 1] == 'S' && tab[x + 1][y - 1] == 'M' && tab[x + 1][y + 1] == 'S') {
                return true;
            }
            else if (tab[x - 1][y - 1] == 'S' && tab[x - 1][y + 1] == 'S' && tab[x + 1][y - 1] == 'M' && tab[x + 1][y + 1] == 'M') {
                return true;
            }
            else if (tab[x - 1][y - 1] == 'S' && tab[x - 1][y + 1] == 'M' && tab[x + 1][y - 1] == 'S' && tab[x + 1][y + 1] == 'M') {
                return true;
            }
        }
        return false;
    }
}
