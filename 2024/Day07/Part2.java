public class Part2 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/test";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            long result = 0;

            while ((ligne = bufferedReader.readLine()) != null) {
                String[] parts = ligne.split(":");
                long resultatTarget = Long.parseLong(parts[0]);
                String[] nbs = parts[1].trim().split(" ");

                long[] nombres = new long[nbs.length];
                for (int i = 0; i < nbs.length; i++) {
                    nombres[i] = Long.parseLong(nbs[i]);
                }

                if (Calculer(nombres, 0, nombres[0], resultatTarget)) {
                    result += resultatTarget;
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean Calculer(long[] nombres, int ind, long valeurA, long resultatTarget) {
        if (ind == nombres.length - 1) {
            return resultatTarget == valeurA;
        }

        if (Calculer(nombres, ind + 1, valeurA + nombres[ind+1], resultatTarget)) {
            return true;
        }

        if (Calculer(nombres, ind + 1, valeurA * nombres[ind+1], resultatTarget)) {
            return true;
        }

        String concat = String.valueOf(valeurA) + String.valueOf(nombres[ind+1]);
        if (Calculer(nombres, ind + 1, Long.parseLong(concat), resultatTarget)) {
            return true;
        }

        return false;
    }
}
