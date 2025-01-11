import java.util.*;

public class Main {
    static final int NOT = 10000;
    static final int MAX = 2 * NOT + 1;
    static int n, m, num = 1;
    static int[] id = new int[MAX];
    static int[] finished = new int[MAX];
    static List<Integer>[] graph = new ArrayList[MAX];
    static List<List<Integer>> scc = new ArrayList<>();
    static Stack<Integer> stk = new Stack<>();

    static int notValue(int val) {
        if (val > NOT) return val - NOT;
        else return val + NOT;
    }

    static int fitValue(int val) {
        if (val < 0) return -val + NOT;
        else return val;
    }

    static int dfs(int node) {
        id[node] = num++;
        stk.push(node);

        int res = id[node];

        for (int nxt : graph[node]) {
            if (id[nxt] == 0) res = Math.min(res, dfs(nxt));
            else if (finished[nxt] == 0) res = Math.min(res, id[nxt]);
        }

        if (res == id[node]) {
            List<Integer> temp = new ArrayList<>();
            int idx = scc.size() + 1;
            while (true) {
                int top = stk.pop();
                finished[top] = idx;
                temp.add(top);
                if (top == node) break;
            }
            scc.add(temp);
        }

        return res;
    }

    static void createScc() {
        for (int i = 1; i <= n; i++) {
            if (id[i] == 0) dfs(i);
            if (id[notValue(i)] == 0) dfs(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a = fitValue(a);
            b = fitValue(b);
            graph[notValue(a)].add(b);
            graph[notValue(b)].add(a);
        }

        createScc();

        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (finished[i] == finished[notValue(i)]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? 1 : 0);
    }
}
