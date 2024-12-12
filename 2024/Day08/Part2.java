public class Part2 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input8.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            char[][] tab = new char[50][50];
            int ind = 0;
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
                        int diffX = a[0] - b[0];
                        int diffY = a[1] - b[1];
                        ajouter1(a, diffX, diffY, antinodes);
                        ajouter2(b, diffX, diffY, antinodes);
                        antinodes.add(a[0] + "," + a[1]);
                        antinodes.add(b[0] + "," + b[1]);
                    }
                }
            }
            System.out.println(antinodes.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ajouter1(int[] a, int diffX, int diffY, Set<String> antinodes) {

        int x = a[0] + diffX;
        int y = a[1] + diffY;
        if (x >= 0 && x < 50 && y >= 0 && y < 50) {
            antinodes.add(x + "," + y);
            ajouter1(new int[]{x, y}, diffX, diffY, antinodes);
        }
    }

    private static void ajouter2(int[] b, int diffX, int diffY, Set<String> antinodes) {

        int x = b[0] - diffX;
        int y = b[1] - diffY;
        if (x >= 0 && x < 50 && y >= 0 && y < 50) {
            antinodes.add(x + "," + y);
            ajouter2(new int[]{x, y}, diffX, diffY, antinodes);
        }
    }
}
