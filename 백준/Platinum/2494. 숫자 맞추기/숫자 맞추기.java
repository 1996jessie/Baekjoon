import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] from = new char[10004];
    static char[] to = new char[10004];
    static int[][] dp = new int[10004][11];
    static T[][] child = new T[10004][11];

    static class T {
        int x, y, m;
    }

    static int dpf(int n, int turn) {
        int ret = dp[n][turn];
        if (n == N) return 0;
        if (ret != 0) return ret;

        int l = (to[n] - from[n] - turn + 20) % 10;
        int r = 10 - l;

        int turnLeft = dpf(n + 1, (turn + l) % 10) + l;
        int turnRight = dpf(n + 1, turn) + r;

        T baby = new T();
        if (turnLeft < turnRight) {
            baby.x = n + 1;
            baby.y = (turn + l) % 10;
            baby.m = l;
        } else {
            baby.x = n + 1;
            baby.y = turn;
            baby.m = -r;
        }
        child[n][turn] = baby;
        dp[n][turn] = Math.min(turnLeft, turnRight);
        return dp[n][turn];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        from = br.readLine().toCharArray();
        to = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            from[i] -= '0';
            to[i] -= '0';
        }

        System.out.println(dpf(0, 0));

        int n = 0, turn = 0;
        for (int i = 1; i <= N; i++) {
            T cur = child[n][turn];
            System.out.println((i) + " " + cur.m);
            n = cur.x;
            turn = cur.y;
        }
    }
}
