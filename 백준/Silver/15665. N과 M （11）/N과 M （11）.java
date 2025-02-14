import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, seq;
    static LinkedHashSet<String> result = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        seq = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
        
        for (String s : result) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < M; i++) {
                temp.append(seq[i]).append(" ");
            }
            result.add(temp.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            seq[depth] = arr[i];
            dfs(depth + 1);
        }
    }
}
