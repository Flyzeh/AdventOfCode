public class Part1 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input15.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int result = 0;
            char[][] carte = new char[50][50];
            int ind = 0;
            int x = 0;
            int y = 0;

            while ((ligne = bufferedReader.readLine()) != null) {
                if (ligne.length() == 0) continue;
                if (ligne.charAt(0) == '#') {
                    for (int i = 0; i < ligne.length(); i++) {
                        carte[i][ind] = ligne.charAt(i);
                        if (carte[i][ind] == '@') {
                            x = i;
                            y = ind;
                            carte[i][ind] = '.';
                        }
                    }
                    ind++;
                }
                else {
                    for (int i = 0; i < ligne.length(); i++) {
                        if (ligne.charAt(i) == '>') {
                            if (carte[x + 1][y] == '.') {
                                x++;
                            } else if (carte[x + 1][y] == 'O') {
                                int dx = x + 1;
                                while (carte[dx + 1][y] == 'O') {
                                    dx++;
                                }
                                dx++;
                                if (carte[dx][y] == '.') {
                                    for (int j = x + 1; j <= dx; j++) {
                                        carte[j][y] = 'O';
                                    }
                                    carte[x + 1][y] = '.';
                                    x++;
                                }
                            }
                        } else if (ligne.charAt(i) == '^') {
                            if (carte[x][y - 1] == '.') {
                                y--;
                            } else if (carte[x][y - 1] == 'O') {
                                int dy = y - 1;
                                while (carte[x][dy - 1] == 'O') {
                                    dy--;
                                }
                                dy--;
                                if (carte[x][dy] == '.') {
                                    for (int j = y - 1; j >= dy; j--) {
                                        carte[x][j] = 'O';
                                    }
                                    carte[x][y - 1] = '.';
                                    y--;
                                }

                            }
                        } else if (ligne.charAt(i) == '<') {
                            if (carte[x - 1][y] == '.') {
                                x--;
                            } else if (carte[x - 1][y] == 'O') {
                                int dx = x - 1;
                                while (carte[dx - 1][y] == 'O') {
                                    dx--;
                                }
                                dx--;
                                if (carte[dx][y] == '.') {
                                    for (int j = x - 1; j >= dx; j--) {
                                        carte[j][y] = 'O';
                                    }
                                    carte[x - 1][y] = '.';
                                    x--;
                                }
                            }
                        } else {
                            if (carte[x][y + 1] == '.') {
                                y++;
                            } else if (carte[x][y + 1] == 'O') {
                                int dy = y + 1;
                                while (carte[x][dy + 1] == 'O') {
                                    dy++;
                                }
                                dy++;
                                if (carte[x][dy] == '.') {
                                    for (int j = y + 1; j <= dy; j++) {
                                        carte[x][j] = 'O';
                                    }
                                    carte[x][y + 1] = '.';
                                    y++;
                                }
                            }
                        }
                    }
                }

            }
            for (int k = 0; k < carte.length; k++) {
                for (int j = 0; j < carte[k].length; j++) {
                    if (carte[j][k] == 'O') {
                        result += (k * 100 + j);
                    }
                }
            }


            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
