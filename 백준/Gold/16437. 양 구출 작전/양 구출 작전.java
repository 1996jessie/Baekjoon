import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static char[] type;
    static long[] amount;

    static long dfs(int node) {
        long total = 0;
        for (int nxt : graph[node]) {
            total += dfs(nxt);
        }
        if (type[node] == 'S') {
            total += amount[node];
        } else {
            total -= amount[node];
            if (total < 0) total = 0;
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        type = new char[N + 1];
        amount = new long[N + 1];

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            long a = Long.parseLong(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            type[i] = t;
            amount[i] = a;
            graph[p].add(i);
        }

        System.out.println(dfs(1));
    }
}
