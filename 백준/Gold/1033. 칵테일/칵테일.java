import java.util.*;

public class Main {
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean[] visited;
    static long[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }

        D[0] = lcm;
        dfsFunc(0);

        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + (i == N - 1 ? "\n" : " "));
        }
    }

    static void dfsFunc(int Node) {
        visited[Node] = true;
        for (cNode adjNode : A[Node]) {
            int next = adjNode.node;
            if (!visited[next]) {
                D[next] = D[Node] * adjNode.q / adjNode.p;
                dfsFunc(next);
            }
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static class cNode {
        int node;
        int p;
        int q;

        public cNode(int node, int p, int q) {
            this.node = node;
            this.p = p;
            this.q = q;
        }
    }
}

