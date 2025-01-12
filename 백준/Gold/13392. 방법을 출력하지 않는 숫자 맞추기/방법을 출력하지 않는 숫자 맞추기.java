import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1000000;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        init(dp);
        int[] cur = new int[N + 1];
        int[] target = new int[N + 1];
        initState(br.readLine(), cur);
        initState(br.readLine(), target);
        int left1 = calRotation(cur[1], target[1], true);
        dp[1][left1] = left1;
        dp[1][0] = calRotation(cur[1], target[1], false);

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (dp[i - 1][j] != MAX) {
                    int curNum = rotation(cur[i], j);
                    int left = calRotation(curNum, target[i], true);
                    int nextLeft = rotation(j, left);
                    dp[i][nextLeft] = Math.min(dp[i][nextLeft], dp[i - 1][j] + left);
                    int right = calRotation(curNum, target[i], false);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + right);
                }
            }
        }

        int answer = MAX;
        for (int i = 0; i <= 9; i++) {
            answer = Math.min(answer, dp[N][i]);
        }
        System.out.println(answer);
    }

    static void init(int[][] arr) {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                arr[i][j] = MAX;
            }
        }
    }

    static void initState(String str, int[] arr) {
        for (int i = 0; i < str.length(); i++) {
            arr[i + 1] = str.charAt(i) - '0';
        }
    }

    static int rotation(int c, int cnt) {
        return (c + cnt) % 10;
    }

    static int calRotation(int c, int t, boolean left) {
        if (c == t) {
            return 0;
        }
        if (left) {
            if (c < t) {
                return t - c;
            }
            return (t + 10) - c;
        }
        if (c > t) {
            return c - t;
        }
        return (c + 10) - t;
    }
}
