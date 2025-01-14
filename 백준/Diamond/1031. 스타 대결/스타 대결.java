import java.util.*;

public class Main {
    static int N, M;
    static int[][] C = new int[111][111], f = new int[111][111];
    static List<Integer>[] adj = new ArrayList[111];
    static final int src = 0, sink = 110;

    public static void addEdge(int from, int to, int cc) {
        adj[from].add(to);
        adj[to].add(from);
        C[from][to] = cc;
    }

    public static int maxFlow() {
        int ret = 0;

        while (true) {
            Queue<Integer> q = new LinkedList<>();
            int[] par = new int[111];
            Arrays.fill(par, -1);

            q.offer(src);

            while (!q.isEmpty() && par[sink] == -1) {
                int here = q.poll();
                for (int next : adj[here]) {
                    if (C[here][next] - f[here][next] > 0 && par[next] == -1) {
                        q.offer(next);
                        par[next] = here;
                    }
                }
            }

            if (par[sink] == -1) {
                break;
            }

            for (int i = sink; i != src; i = par[i]) {
                f[par[i]][i]++;
                f[i][par[i]]--;
            }

            ret++;
        }

        return ret;
    }

    public static boolean isPossibleErase(int from, int to) {
        f[from][to] = 0;
        f[to][from] = 1;
        f[src][from]--;
        f[from][src]++;
        f[to][sink]--;
        f[sink][to]++;

        int ret = 0;

        while (true) {
            Queue<Integer> q = new LinkedList<>();
            int[] par = new int[111];
            Arrays.fill(par, -1);

            q.offer(src);

            while (!q.isEmpty() && par[sink] == -1) {
                int here = q.poll();
                for (int next : adj[here]) {
                    if ((here == from && next == to) || (here == to && next == from)) {
                        continue;
                    }

                    if (here > src && here < from && f[here][next] == 0) {
                        continue;
                    }

                    if (here == from && next > N && next < to && f[here][next] == 0) {
                        continue;
                    }

                    if (C[here][next] - f[here][next] > 0 && par[next] == -1) {
                        q.offer(next);
                        par[next] = here;
                    }
                }
            }

            if (par[sink] == -1) {
                break;
            }

            for (int i = sink; i != src; i = par[i]) {
                f[par[i]][i]++;
                f[i][par[i]]--;
            }

            ret++;
        }

        return ret == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum_A = 0, sum_B = 0;

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < 111; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int n = 1; n <= N; n++) {
            int A = sc.nextInt();
            addEdge(src, n, A);
            sum_A += A;
        }

        for (int m = 1; m <= M; m++) {
            int B = sc.nextInt();
            addEdge(m + N, sink, B);
            sum_B += B;
        }

        if (sum_A != sum_B) {
            System.out.println("-1");
            return;
        }

        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                addEdge(n, m + N, 1);
            }
        }

        if (maxFlow() != sum_A) {
            System.out.println("-1");
            return;
        } else {
            for (int n = 1; n <= N; n++) {
                for (int m = 1; m <= M; m++) {
                    if (f[n][m + N] > 0) {
                        if (!isPossibleErase(n, m + N)) {
                            f[n][m + N] = 1;
                            f[m + N][n] = 0;
                            f[src][n]++;
                            f[n][src]--;
                            f[m + N][sink]++;
                            f[sink][m + N]--;
                        }
                    }
                }
            }

            for (int n = 1; n <= N; n++) {
                for (int m = 1; m <= M; m++) {
                    System.out.print(f[n][m + N]);
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
