public class Part2 {

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


            for (int i = 0; i < left.size(); i++) {
                int count = 0;
                for (int j = 0; j < right.size(); j++) {
                    if (right.get(j).equals(left.get(i))) {
                        count++;
                    }
                }
                result += left.get(i) * count;
            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
