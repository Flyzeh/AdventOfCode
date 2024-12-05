public class Part2 {

    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input3.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int result = 0;
            boolean autorisation = true;

            while ((ligne = bufferedReader.readLine()) != null) {

                Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");

                Matcher matcher = pattern.matcher(ligne);

                while (matcher.find()) {

                    if (matcher.group(0).equals("do()")) {
                        autorisation = true;
                    }

                    else if (matcher.group(0).equals("don't()")) {
                        autorisation = false;
                    }

                    else  {
                        int x = Integer.parseInt(matcher.group(1));
                        int y = Integer.parseInt(matcher.group(2));
                        if (autorisation) {
                            result += x * y;
                        }
                    }
                }
            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
