import java.io.*;
import java.util.Arrays;

public class Main {
    private static int N;
    private static int M;
    private static int[][] room;
    private static boolean[][] nodes;
    private static int visitCount;
    private static int[] visit;
    private static int[] matched;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] scopes = { { -1, 1 }, { -1, 0 }, { -1, -1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

        int C = Integer.parseInt(reader.readLine());

        while (C-- > 0) {
            String[] temp = reader.readLine().split(" ");

            N = Integer.parseInt(temp[0]);
            M = Integer.parseInt(temp[1]);

            boolean[][] canSit = new boolean[N][M];
            int numbering = 1;
            int broken = 0;

            room = new int[N][M];
            nodes = new boolean[N * M][N * M];
            visitCount = 1;

            for (int n = 0; n < N; n++) {
                temp = reader.readLine().split("");

                for (int m = 0; m < M; m++) {
                    room[n][m] = numbering++;
                    if (temp[m].equals(".")) {
                        canSit[n][m] = true;
                    } else {
                        canSit[n][m] = false;
                        broken++;
                    }
                }
            }

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m += 2) {
                    if (canSit[n][m]) {
                        for (int[] scope : scopes) {
                            int no = n + scope[1];
                            int mo = m + scope[0];

                            if (no > -1 && mo > -1 && no < N && mo < M && canSit[no][mo]) {
                                nodes[room[n][m] - 1][room[no][mo] - 1] = true;
                            }
                        }
                    }
                }
            }

            int result = bipartite();

            writer.write(Integer.toString(N * M - broken - result));
            writer.newLine();
            writer.flush();
        }

        writer.close();
        reader.close();
    }

    private static int bipartite() {
        int size = 0;

        visit = new int[N * M];
        matched = new int[N * M];
        Arrays.fill(matched, -1);

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m += 2) {
                visitCount++;
                size += dfs(room[n][m] - 1);
            }
        }

        return size;
    }

    private static int dfs(int num) {
        if (visit[num] != visitCount) {
            visit[num] = visitCount;

            for (int i = 0; i < N * M; i++) {
                if (nodes[num][i]) {
                    if (matched[i] == -1 || dfs(matched[i]) == 1) {
                        matched[i] = num;
                        return 1;
                    }
                }
            }
        }

        return 0;
    }
}
