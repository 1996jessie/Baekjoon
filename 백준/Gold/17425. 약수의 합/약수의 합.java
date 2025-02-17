import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int MAX = 1000000;
        long[] f = new long[MAX + 1];
        long[] g = new long[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j += i) {
                f[j] += i;
            }
        }

        for (int i = 1; i <= MAX; i++) {
            g[i] = g[i - 1] + f[i];
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            bw.write(g[N] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
