public class Part2 {
    public static void main(String[] args) {
        long[] register = {0L, 1L, 2L, 3L, 2024L, 0L, 0L};
        long[] program = {2L,4L,1L,1L,7L,5L,1L,5L,4L,5L,0L,3L,5L,5L,3L,0L};
        boolean jnz = false;


        int place = program.length-1;
        List<Long> A = new ArrayList<>();
        A.add(0L);

        while (place >= 0) {
            List<Long> resA = new ArrayList<>();
            long output = program[place];

            for (int i = 0; i < A.size(); i++) {
                long newA = A.get(i) * 8;
                for (int j = 0; j < 8; j++) {
                    long cra = newA + j;
                    register[4] = cra;
                    long tab = Program(program, register, jnz);
                    if (output == tab) {
                        System.out.println(tab);
                        resA.add(cra);
                    }
                }
            }
            place -= 1;
            A = List.copyOf(resA);
        }
        System.out.println(Collections.min(A));

    }

    public static long Program(long[] program, long[] register, boolean jnz) {
        long[] copyregister = Arrays.copyOf(register, register.length);
        for (int i = 0; i < program.length; i += 2) {
            if (jnz) {
                i -= 2;
                jnz = false;
            }
            if (program[i] == 0) {
                copyregister[4] = copyregister[4] / (int) (Math.pow(2, copyregister[(int)program[i+1]]));
            }
            else if (program[i] == 1) {
                copyregister[5] = copyregister[5] ^ program[i+1];

            }
            else if (program[i] == 2) {
                copyregister[5] = copyregister[(int)program[i+1]] % 8;
            }
            else if (program[i] == 3) {
                if (copyregister[4] != 0) {
                    i = (int) copyregister[(int)program[i+1]];
                    jnz = true;
                }
            }
            else if (program[i] == 4) {
                copyregister[5] = copyregister[5] ^ copyregister[6];
            }
            else if (program[i] == 5) {
                return (copyregister[(int)program[i+1]] % 8);
            }
            else if (program[i] == 6) {
                copyregister[5] = copyregister[4] / (int) (Math.pow(2, copyregister[(int)program[i+1]]));
            }
            else if (program[i] == 7) {
                copyregister[6] = copyregister[4] / (int) (Math.pow(2, copyregister[(int)program[i+1]]));

            }
        }
        return 0;
    }
}
