import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                count += n / 5;
                n = 0;
                break;
            }
            n -= 2;
            count++;
        }

        System.out.println(n == 0 ? count : -1);
    }
}
