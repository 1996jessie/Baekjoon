import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long N = 0, total = 0;

        while (total + (N + 1) <= S) {
            N++;
            total += N;
        }

        System.out.println(N);
    }
}
