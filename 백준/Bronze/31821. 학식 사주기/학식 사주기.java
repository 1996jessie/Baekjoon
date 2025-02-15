import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N];

        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        int M = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0; i < M; i++) {
            total += prices[Integer.parseInt(br.readLine()) - 1];
        }

        System.out.println(total);
    }
}
