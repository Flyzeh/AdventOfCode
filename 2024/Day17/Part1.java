public class Part1 {
    public static void main(String[] args) {
            int[] register = {0, 1, 2, 3, 2024, 0, 0};
            int[] program = {0,3,5,4,3,0};
            List<Integer> result = new ArrayList<>();
            boolean jnz = false;

            for (int i = 0; i < program.length; i += 2) {
                if (jnz) {
                    i -= 2;
                    jnz = false;
                    System.out.println(i);
                }
                if (program[i] == 0) {
                    register[4] = register[4] / (int) (Math.pow(2, register[program[i+1]]));
                }
                else if (program[i] == 1) {
                    System.out.println(register[5]);
                    System.out.println(register[program[i+1]]);
                    register[5] = register[5] ^ program[i+1];

                    System.out.println(3);
                }
                else if (program[i] == 2) {
                    register[5] = register[program[i+1]] % 8;
                }
                else if (program[i] == 3) {
                    if (register[4] != 0) {
                        i = register[program[i+1]];
                        jnz = true;
                    }
                }
                else if (program[i] == 4) {
                    register[5] = register[5] ^ register[6];
                }
                else if (program[i] == 5) {
                    result.add(register[program[i+1]] % 8);
                }
                else if (program[i] == 6) {
                    register[5] = register[4] / (int) (Math.pow(2, register[program[i+1]]));
                }
                else if (program[i] == 7) {
                        register[6] = register[4] / (int) (Math.pow(2, register[program[i+1]]));

                }
            System.out.println(Arrays.toString(register));
                System.out.println(result);
            }

            String s = "";
            for (int i = 0; i < result.size(); i++) {
                if (i == result.size() - 1) {
                    s += result.get(i);
                }
                else
                    s += result.get(i) + ",";
            }
            System.out.println(s);
    }
}

