public class Part2 {
    public static void main(String[] args) {
        String cheminFichier = "";

        Map<Integer, List<Integer>> before = new HashMap<>();
        Map<Integer, List<Integer>> after = new HashMap<>();
        int result = 0;
        boolean maj = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = bufferedReader.readLine()) != null) {
                if (ligne.isEmpty()) {
                    maj = true;
                    continue;
                }

                if (!maj) {
                    String[] parts = ligne.split("\\|");
                    int left = Integer.parseInt(parts[0].trim());
                    int right = Integer.parseInt(parts[1].trim());

                    if (!before.containsKey(left)) {
                        before.put(left, new ArrayList<>());
                    }
                    if (!after.containsKey(left)) {
                        after.put(left, new ArrayList<>());
                    }
                    if (!before.containsKey(right)) {
                        before.put(right, new ArrayList<>());
                    }
                    if (!after.containsKey(left)) {
                        before.put(right, new ArrayList<>());
                    }

                    after.get(left).add(right);
                    before.get(right).add(left);
                } else {
                    String[] parts = ligne.split(",");
                    int[] majP = new int[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        majP[i] = Integer.parseInt(parts[i].trim());
                    }

                    boolean trié = true;

                    for (int i = 0; i < majP.length; i++) {
                        for (int j = 0; j < i; j++) {
                            if (after.get(majP[i]).contains(majP[j]))
                                trié = false;
                        }

                        for (int k = i + 1; k < majP.length; k++) {
                            if (before.get(majP[i]).contains(majP[k]))
                                trié = false;
                        }

                    }

                    if (!trié) {

                        Integer[] MajTrie = new Integer[majP.length];
                        for (int i = 0; i < majP.length; i++) {
                            MajTrie[i] = majP[i];
                        }

                        Arrays.sort(MajTrie, (a, b) -> {
                            if (before.get(a).contains(b)) {
                                return 1;
                            } else if (after.get(a).contains(b)) {
                                return -1;
                            } else {
                                return 0;
                            }
                        });

                        result += MajTrie[MajTrie.length / 2];
                    }
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
