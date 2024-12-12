public class Part1 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input8.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            char[][] tab = new char[50][50];
            int ind = 0;
            int result = 0;
            Map<Character, List<int[]>> antennes = new HashMap<>();

            while ((ligne = bufferedReader.readLine()) != null) {
                for (int i = 0; i < ligne.length(); i++) {
                    tab[i][ind] = ligne.charAt(i);
                    if (ligne.charAt(i) != '.') {
                        if (!antennes.containsKey(ligne.charAt(i))) {
                            antennes.put(ligne.charAt(i), new ArrayList<>());
                        }
                        antennes.get(ligne.charAt(i)).add(new int[]{i, ind});
                    }
                }
                ind++;
            }
            Set<String> antinodes = new HashSet<>();

            for (Character coord : antennes.keySet()) {
                List<int[]> positions = antennes.get(coord);


                for (int i = 0; i < positions.size(); i++) {
                    for (int j = i + 1; j < positions.size(); j++) {
                        int[] a = positions.get(i);
                        int[] b = positions.get(j);
                        
                        ajouter(a, b, antinodes);
                    }
                }
            }

            for (String antinode : antinodes) {
                String[] coords = antinode.split(",");
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                if (x >= 0 && x < tab.length && y >= 0 && y < tab[0].length) {
                    result++;
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ajouter(int[] a, int[] b, Set<String> antinodes) {
        int diffX = a[0] - b[0];
        int diffY = a[1] - b[1];

        antinodes.add((b[0] - diffX) + "," + (b[1] - diffY));
        antinodes.add((a[0] + diffX) + "," + (a[1] + diffY));
    }
}
