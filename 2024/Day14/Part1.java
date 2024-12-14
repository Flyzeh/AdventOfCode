public class Part1 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input14.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int Q1 = 0;
            int Q2 = 0; 
            int Q3 = 0; 
            int Q4 = 0;

            while ((ligne = bufferedReader.readLine()) != null) {
                String regex = "p=(\\d+),(\\d+) v=(\\-?\\d+),(\\-?\\d+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(ligne);

                if (matcher.find()) {
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    int newx = Integer.parseInt(matcher.group(3));
                    int newy = Integer.parseInt(matcher.group(4));

                    for (int i = 0; i < 100; i++) {
                        x = (x + newx + 101) % 101;
                        y = (y + newy + 103) % 103;
                    }

                    if (x < 50 && y < 51) 
                      Q1++;
                    else if (x > 50 && y < 51) 
                      Q2++;
                    else if (x < 50 && y > 51)
                      Q3++;
                    else if (x > 50 && y > 51) 
                      Q4++;
                }
            }

            System.out.println(Q1 * Q2 * Q3 * Q4);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
