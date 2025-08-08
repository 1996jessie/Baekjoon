import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int D = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int[] a = new int[31];
        int[] b = new int[31];

        a[1] = 1;
        b[2] = 1;

        for (int i = 3; i <= D; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }

        for (int A = 1; A <= K; A++) {
            int B = (K - a[D] * A);
            if (B % b[D] != 0) continue;
            B = B / b[D];
            if (A <= B) {
                System.out.println(A);
                System.out.println(B);
                return;
            }
        }
    }
}
