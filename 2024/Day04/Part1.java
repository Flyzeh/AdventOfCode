public class Part1 {
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

            int mvts[][] = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

            for (int i = 0; i < 140; i++) {
                for (int j = 0; j < 140; j++) {
                    if (tab[i][j] == 'X') {
                        for (int[] mv : mvts) {
                            if (Check(tab, i, j, mv[0], mv[1], "XMAS")) {
                                result++;
                            }
                        }
                    }
                }
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean Check(char[][] tab, int startX, int startY, int mvtx, int mvty, String mot) {


        for (int k = 0; k < 4; k++) {
            int x = startX + mvtx * k;
            int y = startY + mvty * k;

            if (x < 0 || x >= tab.length || y < 0 || y >= tab[0].length) {
                return false;
            }

            if (tab[x][y] != mot.charAt(k)) {
                return false;
            }
        }

        return true;
    }
}
