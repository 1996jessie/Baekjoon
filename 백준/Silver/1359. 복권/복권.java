import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double totalWays = combination(N, M);
        double winningWays = 0;

        for (int i = K; i <= M; i++) {
            winningWays += combination(M, i) * combination(N - M, M - i);
        }

        System.out.println(winningWays / totalWays);
    }

    private static double combination(int n, int r) {
        if (r > n) {
            return 0;
        }
        double result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
