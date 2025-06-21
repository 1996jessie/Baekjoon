import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int original = n;

        do {
            int a = n / 10;
            int b = n % 10;
            int sum = a + b;
            n = b * 10 + (sum % 10);
            cnt++;
        } while (n != original);

        System.out.println(cnt);
    }
}
