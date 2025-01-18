import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 83;
    static int N, M;
    static int[] d;
    static char[][] a;
    static List<Integer>[] v;
    static boolean[] used, able;

    static boolean dfs(int cur) {
        for (int next : v[cur]) {
            if (used[next]) {
                continue;
            }
            used[next] = true;
            if (d[next] == -1 || dfs(d[next])) {
                d[next] = cur;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            v = new ArrayList[MAX * MAX];
            d = new int[MAX * MAX];
            able = new boolean[MAX * MAX];
            Arrays.fill(d, -1);

            for (int i = 0; i < MAX * MAX; i++) {
                v[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            a = new char[N][M];
            int ans = N * M;
            int res = 0;

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    a[i][j] = s.charAt(j);
                    if (a[i][j] == 'x') {
                        ans--;
                    } else {
                        able[i * M + j] = true;
                    }
                }
            }

            for (int j = 0; j < M; j += 2) {
                for (int i = 0; i < N; i++) {
                    int cur = i * M + j;
                    if (able[cur]) {
                        int left = cur - 1;
                        int right = cur + 1;
                        int downLeft = left + M;
                        int downRight = right + M;
                        int upLeft = left - M;
                        int upRight = right - M;

                        if (j > 0 && able[left]) {
                            v[cur].add(left);
                        }
                        if (j != M - 1 && able[right]) {
                            v[cur].add(right);
                        }
                        if (i != N - 1 && j > 0 && able[downLeft]) {
                            v[cur].add(downLeft);
                        }
                        if (i != N - 1 && j != M - 1 && able[downRight]) {
                            v[cur].add(downRight);
                        }
                        if (i > 0 && j > 0 && able[upLeft]) {
                            v[cur].add(upLeft);
                        }
                        if (i > 0 && j != M - 1 && able[upRight]) {
                            v[cur].add(upRight);
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int cur = i * M + j;
                    used = new boolean[MAX * MAX];
                    if (dfs(cur)) {
                        res++;
                    }
                }
            }
            sb.append(ans - res).append("\n");
        }
        System.out.print(sb);
    }
}
