import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int MAX = 1000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> inputs = new ArrayList<>();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            inputs.add(n);
        }
        for (int n : inputs) {
            boolean found = false;
            for (int a = 3; a <= n / 2; a += 2) {
                int b = n - a;
                if (isPrime[a] && isPrime[b]) {
                    bw.write(n + " = " + a + " + " + b + "\n");
                    found = true;
                    break;
                }
            }
            if (!found) {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
        }
        bw.flush();
    }
}
