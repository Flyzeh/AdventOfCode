public class Part2 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input13.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            long result = 0;
            long xfinal = 0L;
            long yfinal = 0L;
            int ax = 0;
            int ay = 0;
            int bx = 0;
            int by = 0;
            int ind = 1;

            while ((ligne = bufferedReader.readLine()) != null) {

                if (ind < 3) {
                    String regex = "X\\+(=?\\d+), Y\\+(-?\\d+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(ligne);
                    while (matcher.find()) {
                        if (ind == 1) {
                            ax = Integer.parseInt(matcher.group(1));
                            ay = Integer.parseInt(matcher.group(2));
                        }
                        else {
                            bx = Integer.parseInt(matcher.group(1));
                            by = Integer.parseInt(matcher.group(2));
                        }
                    }
                }
                else if (ind == 3) {
                    String regex = "X=(\\d+), Y=(\\d+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(ligne);
                    while (matcher.find()) {
                        xfinal = Integer.parseInt(matcher.group(1)) + 10000000000000L;
                        yfinal = Integer.parseInt(matcher.group(2)) + 10000000000000L;
                        long[] nbappuyer = Equations(ax, ay, bx, by, xfinal, yfinal);
                        if (nbappuyer != null) {
                            result += nbappuyer[0] * 3 + nbappuyer[1];
                        }
                    }
                }
                else {
                    ind = 0;
                }
                ind++;
            }
            System.out.println(result);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long[] Equations(int ax, int ay, int bx, int by, long xfinal, long yfinal) {
        int det = ax * by - bx * ay;

        if (det == 0) {
            return null;
        }


        long dx = (xfinal * by - bx * yfinal);
        long dy = (ax * yfinal - xfinal * ay);

        if (dx % det != 0 || dy % det != 0) {
            return null;
        }

        dx /= det;
        dy /= det;

        if (dx >= 0 && dy >= 0) {
            return new long[]{dx, dy};
        } else {
            return null;
        }
    }
}
