import java.io.*;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static char[] expr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expr = br.readLine().toCharArray();
        dfs(0, expr[0] - '0');
        System.out.println(max);
    }

    static void dfs(int idx, int result) {
        if (idx == N - 1) {
            max = Math.max(max, result);
            return;
        }

        int next = expr[idx + 2] - '0';
        dfs(idx + 2, calculate(result, expr[idx + 1], next));

        if (idx + 4 < N) {
            int bracket = calculate(next, expr[idx + 3], expr[idx + 4] - '0');
            dfs(idx + 4, calculate(result, expr[idx + 1], bracket));
        }
    }

    static int calculate(int a, char op, int b) {
        if (op == '+') {
            return a + b;
        }
        if (op == '-') {
            return a - b;
        }
        return a * b;
    }
}
