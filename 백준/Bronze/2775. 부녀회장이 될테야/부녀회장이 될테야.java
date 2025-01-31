import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] apt = new int[15][15];

        for (int i = 0; i < 15; i++) {
            apt[0][i] = i;
        }

        for (int k = 1; k < 15; k++) {
            for (int n = 1; n < 15; n++) {
                apt[k][n] = apt[k][n - 1] + apt[k - 1][n];
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]).append("\n");
        }

        System.out.print(sb);
    }
}
