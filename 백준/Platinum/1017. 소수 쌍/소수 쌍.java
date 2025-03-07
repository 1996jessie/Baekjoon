import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 2000;
    static int[] apair, bpair;
    static boolean[] isPrime, check;
    static List<Integer> a, b;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        isPrime = initPrime(MAX);

        a = new ArrayList<>();
        b = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        boolean f = isEven(first);
        a.add(first);

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!(f ^ isEven(num))) {
                a.add(num);
            } else {
                b.add(num);
            }
        }

        if (a.size() != b.size()) {
            System.out.println(-1);
            return;
        }

        list = new ArrayList[a.size()];
        for (int i = 0; i < a.size(); i++) {
            list[i] = new ArrayList<>();
            for (int j = 0; j < b.size(); j++) {
                if (isPrime[a.get(i) + b.get(j)]) {
                    list[i].add(j);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        check = new boolean[a.size()];
        apair = new int[a.size()];
        bpair = new int[b.size()];
        for (int i = 0; i < list[0].size(); i++) {
            int b_first = list[0].get(i);
            Arrays.fill(apair, -1);
            Arrays.fill(bpair, -1);
            apair[0] = b_first;
            bpair[b_first] = 0;

            int cnt = 1;
            for (int j = 0; j < a.size(); j++) {
                Arrays.fill(check, false);
                if (dfs(j)) cnt++;
            }

            if (cnt == b.size()) {
                ans.add(b.get(apair[0]));
            }
        }

        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }

        ans.stream().sorted().forEach(s -> System.out.print(s + " "));
    }

    static boolean dfs(int here) {
        for (int nxt : list[here]) {
            if (here == 0 || check[nxt]) continue;
            check[nxt] = true;

            if (bpair[nxt] == -1 || dfs(bpair[nxt])) {
                apair[here] = nxt;
                bpair[nxt] = here;
                return true;
            }
        }
        return false;
    }

    static boolean[] initPrime(int size) {
        boolean[] isPrime = new boolean[size + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= size; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= size; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
