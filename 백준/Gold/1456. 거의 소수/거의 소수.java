import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int sqrtB = (int) Math.sqrt(B);
        boolean[] isPrime = new boolean[sqrtB + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= sqrtB; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= sqrtB; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= sqrtB; i++) {
            if (isPrime[i]) {
                long power = (long) i * i;
                while (power <= B) {
                    if (power >= A) {
                        count++;
                    }
                    if (power > B / i) {
                        break;
                    }
                    power *= i;
                }
            }
        }

        System.out.println(count);
    }
}
