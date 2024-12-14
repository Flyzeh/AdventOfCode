public class Part2 {
    public static void main(String[] args) {
        String cheminFichier = "Input/2024/input14.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            int ind = 0;
            HashMap<Integer, Integer[]> robotscoord = new HashMap<>();
            HashMap<Integer, Integer[]> robotsmvt = new HashMap<>();
            HashSet<String> nbrobots = new HashSet<>();

            while ((ligne = bufferedReader.readLine()) != null) {
                String regex = "p=(\\d+),(\\d+) v=(\\-?\\d+),(\\-?\\d+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(ligne);

                if (matcher.find()) {
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    int newx = Integer.parseInt(matcher.group(3));
                    int newy = Integer.parseInt(matcher.group(4));

                    robotscoord.put(ind, new Integer[]{x, y});
                    robotsmvt.put(ind, new Integer[]{newx, newy});
                }
                ind++;
            }

            for (int i = 0; i < 100000; i++) {
                nbrobots.clear();

                for (Map.Entry<Integer, Integer[]> j : robotscoord.entrySet()) {

                    int robotId = j.getKey();
                    Integer[] coord = j.getValue();
                    Integer[] mvt = robotsmvt.get(robotId);


                    coord[0] = (coord[0] + mvt[0] + 101) % 101;
                    coord[1] = (coord[1] + mvt[1] + 103) % 103;

                    robotscoord.put(robotId, coord);

                    String s = coord[0] + "," + coord[1];

                    nbrobots.add(s);
                }

                if (nbrobots.size() == ind) {
                    System.out.println(i+1);
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
