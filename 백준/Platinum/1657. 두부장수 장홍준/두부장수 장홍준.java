import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[] tofuBoard;
    static int[][] scoreBoard;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tofuBoard = new char[N * M];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                tofuBoard[idx++] = s.charAt(j);
            }
        }

        makeScoreBoard();
        initDp();

        System.out.println(recursion(0, 0));
    }

    public static int recursion(int nowTofu, int status) {
        if (nowTofu >= N * M) {
            return 0;
        }
        if (dp[nowTofu][status] != -1) {
            return dp[nowTofu][status];
        }
        if ((status & 1 << 0) != 0) {
            return recursion(nowTofu + 1, status >> 1);
        }
        int score = 0;
        score = Math.max(score, recursion(nowTofu + 1, status >> 1));

        if (nowTofu + M < N * M) {
            score = Math.max(score, scoreBoard[tofuBoard[nowTofu] - 'A'][tofuBoard[nowTofu + M] - 'A']
                    + recursion(nowTofu + 1, (status >> 1) | (1 << M - 1)));
        }

        if (nowTofu % M != M - 1 && (status & 1 << 1) == 0) {
            score = Math.max(score, scoreBoard[tofuBoard[nowTofu] - 'A'][tofuBoard[nowTofu + 1] - 'A']
                    + recursion(nowTofu + 2, status >> 2));
        }

        dp[nowTofu][status] = score;
        return dp[nowTofu][status];
    }

    private static void initDp() {
        dp = new int[N * M][1 << M];
        for (int i = 0; i < N * M; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    private static void makeScoreBoard() {
        scoreBoard = new int[6][6];
        scoreBoard[0] = new int[]{10, 8, 7, 5, 0, 1};
        scoreBoard[1] = new int[]{8, 6, 4, 3, 0, 1};
        scoreBoard[2] = new int[]{7, 4, 3, 2, 0, 1};
        scoreBoard[3] = new int[]{5, 3, 2, 2, 0, 1};
        scoreBoard[4] = new int[]{0, 0, 0, 0, 0, 0};
        scoreBoard[5] = new int[]{1, 1, 1, 1, 0, 0};
    }
}
