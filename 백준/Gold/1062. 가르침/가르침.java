import java.io.*;
import java.util.*;

public class Main {
    static int N, K, max;
    static String[] words;
    static boolean[] learned;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        learned = new boolean[26];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            words[i] = s.substring(4, s.length() - 4);
        }
        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;
        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == K - 5) {
            int readable = 0;
            for (String w : words) {
                boolean ok = true;
                for (char ch : w.toCharArray()) {
                    if (!learned[ch - 'a']) {
                        ok = false;
                        break;
                    }
                }
                if (ok) readable++;
            }
            max = Math.max(max, readable);
            return;
        }
        for (int i = idx; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                dfs(i + 1, cnt + 1);
                learned[i] = false;
            }
        }
    }
}
