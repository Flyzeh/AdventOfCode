public class Part2 {

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
                    Set<String> chemin = CalculChemin(carte, map, new int[]{endl, endc}, lignes, colonnes);
                    System.out.println(chemin.size());
                    break;
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

    public static Set<String> CalculChemin(List<String> carte, Map<String, Integer> visited, int[] end, int l, int c) {
        int mincoutend = Integer.MAX_VALUE;
        Set<String> cheminD = new HashSet<>();
        List<Noeud> File = new ArrayList<>();

        int[][] mvts = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        for (int i = 0; i < 4; i++) {
            String lastNoeud = end[0] + "," + end[1] + "," + i;
            mincoutend = Math.min(mincoutend, visited.getOrDefault(lastNoeud, Integer.MAX_VALUE));
        }

        for (int i = 0; i < 4; i++) {
            String lastNoeud = end[0] + "," + end[1] + "," + i;
            if (visited.containsKey(lastNoeud) && visited.get(lastNoeud) == mincoutend) {
                cheminD.add(lastNoeud);
                File.add(new Noeud(end[0], end[1], i, mincoutend));
            }
        }

        while (!File.isEmpty()) {
            Noeud n = File.removeLast();
            int x = n.ligne;
            int y = n.colonne;
            int d = n.dir;
            int cout = visited.getOrDefault(x + "," + y + "," + d, Integer.MAX_VALUE);
            int[] mvt = mvts[d];
            int lastx = x - mvt[0];
            int lasty = y - mvt[1];

            if (0 <= lastx && lastx < l && 0 <= lasty && lasty < c && carte.get(lastx).charAt(lasty) != '#') {
                int lastcout = cout - 1;
                if (visited.getOrDefault(lastx + "," + lasty + "," + d, Integer.MAX_VALUE) == lastcout) {
                    String lastn = lastx + "," + lasty + "," + d;
                    cheminD.add(lastn);
                    File.add(new Noeud(lastx, lasty, d, lastcout));
                }
            }

            int[] turn = {(d - 1 + 4) % 4, (d + 1) % 4};
            for (int i = 0; i < turn.length; i++) {
                String lastn = x + "," + y + "," + turn[i];
                if (visited.getOrDefault(lastn, Integer.MAX_VALUE) == cout - 1000) {
                    cheminD.add(lastn);
                    File.add(new Noeud(x, y, turn[i], cout - 1000));
                }
            }
        }

        Set<String> chemin = new HashSet<>();
        for (String position : cheminD) {
            String[] parts = position.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            chemin.add(x + "," + y);
        }

        return chemin;
    }
    
}
