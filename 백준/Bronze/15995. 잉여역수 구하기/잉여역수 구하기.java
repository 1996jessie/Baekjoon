import java.io.*;

public class Main {
    static long modInverse(long a, long m) {
        long m0 = m, x0 = 0, x1 = 1;
        while (a > 1) {
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }
        if (x1 < 0) {
            x1 += m0;
        }
        return x1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);
        System.out.println(modInverse(a, m));
    }
}
