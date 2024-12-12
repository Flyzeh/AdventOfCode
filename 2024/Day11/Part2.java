public class Part2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String cheminFichier = "Input/2024/input11.txt"; 

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            long result = 0;
            Map<Long, Long> stones = new HashMap<>();

            while ((ligne = bufferedReader.readLine()) != null) {
                String[] parts = ligne.split(" ");
                for (String part : parts) {
                    part = part.trim();
                    long num = Long.parseLong(part);
                    stones.put(num, stones.getOrDefault(num, 0L) + 1);
                }
            }

            for (int i = 1; i <= 75; i++) {
                Map<Long, Long> next = new HashMap<>();

                for (long j : stones.keySet()) {
                    if (j == 0) {
                        next.put(1L, next.getOrDefault(1L, 0L) + stones.get(j));
                    } else if (String.valueOf(j).length() % 2 == 0) {
                        String s = String.valueOf(j);
                        next.put(Long.parseLong(s.substring(0, s.length() / 2)), next.getOrDefault(Long.parseLong(s.substring(0, s.length() / 2)), 0L) + stones.get(j));
                        next.put(Long.parseLong(s.substring(s.length() / 2)), next.getOrDefault(Long.parseLong(s.substring(s.length() / 2)), 0L) + stones.get(j));
                    } else {
                        next.put(2024*j, next.getOrDefault(2024*j, 0L) + stones.get(j));
                    }
                }
                stones = new HashMap<>(next);
            }

            for (long num : stones.keySet()) {
                result += stones.get(num);
            }

            System.out.println(result);
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            double seconds = (double) timeElapsed / 1_000_000_000.0;
            System.out.println("Temps d'exécution en secondes : " + seconds);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
