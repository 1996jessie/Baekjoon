import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);

        boolean[] isSquareFree = new boolean[(int) (max - min + 1)];
        for (int i = 0; i < isSquareFree.length; i++) {
            isSquareFree[i] = true;
        }

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = Math.max(min, (min + square - 1) / square * square);

            for (long j = start; j <= max; j += square) {
                if (j >= min) {
                    isSquareFree[(int) (j - min)] = false;
                }
            }
        }

        int count = 0;
        for (boolean value : isSquareFree) {
            if (value) {
                count++;
            }
        }

        System.out.println(count);
    }
}
