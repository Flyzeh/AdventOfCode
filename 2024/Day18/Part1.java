public class Part1 {


    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input18.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            char[][] carte = new char[71][71];
            for (int i = 0; i < carte.length; i++) {
                for (int j = 0; j < carte[i].length; j++) {
                    carte[i][j] = '.'; 
                }
            }
            int ind = 0;
            while ((ligne = bufferedReader.readLine()) != null) {
                if (ind < 1024) {
                    String parts[] = ligne.split(",");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    carte[x][y] = '#';
                }
                ind++;
            }

            
            System.out.println(Dijkstra(carte));
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int Dijkstra(char[][] carte) {

        int[][] mvts = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> liste = new ArrayList<>();
        liste.add(new int[] {0, 0});
        int[][] dist = new int[71][71];
        for (int i = 0; i < 71; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        while (!liste.isEmpty()) {
            int[] current = liste.remove(0);
            for (int[] mvt : mvts) {
                int x = current[0] + mvt[0];
                int y = current[1] + mvt[1];
                if (x >= 0 && x < 71 && y >= 0 && y < 71 && carte[y][x] != '#' && dist[y][x] == Integer.MAX_VALUE) {
                    dist[y][x] = Math.min(dist[y][x], dist[current[1]][current[0]]+1);
                    liste.add(new int[] {x, y});
                }
            }
        }

        return dist[70][70];
        
    }
}
