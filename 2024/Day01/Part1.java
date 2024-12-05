public class Part1 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            int result = 0;

            while ((ligne = bufferedReader.readLine()) != null) {
                String[] parts = ligne.split("   ");
                left.add(Integer.parseInt(parts[0]));
                right.add(Integer.parseInt(parts[1]));
            }

            Collections.sort(left);
            Collections.sort(right);

            for (int i = 0; i < left.size(); i++) {
                result += Math.abs(left.get(i) - right.get(i));
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
