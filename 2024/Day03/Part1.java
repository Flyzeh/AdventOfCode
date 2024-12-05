public class Part1 {

    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input3.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int result = 0;

            while ((ligne = bufferedReader.readLine()) != null) {

                Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
                Matcher matcher = pattern.matcher(ligne);
                while (matcher.find()) {
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));

                    result += x * y;
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

