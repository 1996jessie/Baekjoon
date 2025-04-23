import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n < 2) {
            System.out.println("BROKEN");
            return;
        }

        if (n == 2 || n == 3) {
            System.out.println("SAFE");
            return;
        }

        if (n % 2 == 0) {
            System.out.println("BROKEN");
            return;
        }

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                System.out.println("BROKEN");
                return;
            }
        }

        System.out.println("SAFE");
    }
}
