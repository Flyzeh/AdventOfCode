public class Part1 {

    static class Noeud implements Comparable<Noeud> {
        int ligne;
        int colonne;
        int dir;
        int cout;

        Noeud(int ligne, int colonne, int dir, int cout) {
            this.ligne = ligne;
            this.colonne = colonne;
            this.dir = dir;
            this.cout = cout;
        }

        public int compareTo(Noeud n) {
            return Integer.compare(this.cout, n.cout);
        }
    }

    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input16.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            List<String> carte = new ArrayList<>();
            String ligne;
            while ((ligne = bufferedReader.readLine()) != null) {
                carte.add(ligne);
            }

            int lignes = carte.size();
            int colonnes = carte.get(0).length();

            int[] dl = {0, -1, 0, 1};
            int[] dc = {1, 0, -1, 0};

            int startl = -1, startc = -1;
            int endl = -1, endc = -1;

            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {
                    if (carte.get(i).charAt(j) == 'S') {
                        startl = i;
                        startc = j;
                    }
                    if (carte.get(i).charAt(j) == 'E') {
                        endl = i;
                        endc = j;
                    }
                }
            }

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {
                    for (int k = 0; k < 4; k++) {
                        map.put(i + "," + j + "," + k, Integer.MAX_VALUE);
                    }
                }
            }

            PriorityQueue<Noeud> pq = new PriorityQueue<>();
            pq.add(new Noeud(startl, startc, 0, 0));
            map.put(startl + "," + startc + "," + 0, 0);

            while (!pq.isEmpty()) {
                Noeud current = pq.poll();
                int l = current.ligne;
                int c = current.colonne;
                int dir = current.dir;
                int cout = current.cout;

                if (l == endl && c == endc) {
                    System.out.println(cout);
                    return;
                }

                int newl = l + dl[dir];
                int newc = c + dc[dir];
                String newcoord1 = newl + "," + newc + "," + dir;

                if (carte.get(l).charAt(c) != '#' && cout + 1 < map.get(newcoord1)) {
                    map.put(newcoord1, cout + 1);
                    pq.add(new Noeud(newl, newc, dir, cout + 1));
                }

                int changement = (dir + 1) % 4;
                String newcoord2 = l + "," + c + "," + changement;

                if (cout + 1000 < map.get(newcoord2)) {
                    map.put(newcoord2, cout + 1000);
                    pq.add(new Noeud(l, c, changement, cout + 1000));
                }

                int changement2 = (dir + 3) % 4;
                String newcoord3 = l + "," + c + "," + changement2;

                if (cout + 1000 < map.get(newcoord3)) {
                    map.put(newcoord3, cout + 1000);
                    pq.add(new Noeud(l, c, changement2, cout + 1000));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
