import java.io.*;

public class Main {
    static int N;
    static int count = 0;
    static boolean[] column;
    static boolean[] diagonal1;
    static boolean[] diagonal2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        column = new boolean[N];
        diagonal1 = new boolean[2 * N - 1];
        diagonal2 = new boolean[2 * N - 1];

        solve(0);
        System.out.println(count);
    }

    public static void solve(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (column[col] || diagonal1[row - col + N - 1] || diagonal2[row + col]) {
                continue;
            }

            column[col] = true;
            diagonal1[row - col + N - 1] = true;
            diagonal2[row + col] = true;

            solve(row + 1);

            column[col] = false;
            diagonal1[row - col + N - 1] = false;
            diagonal2[row + col] = false;
        }
    }
}
