import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Double> memo = new HashMap<>();
    static Map<String, Double> visited = new HashMap<>();
    static int N;
    static String target;

    static double dfs(int[] arr) {
        String key = Arrays.toString(arr);
        if (key.equals(target)) {
            return 0;
        }
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        List<int[]> next = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    int[] tmp = arr.clone();
                    int t = tmp[i];
                    tmp[i] = tmp[j];
                    tmp[j] = t;
                    next.add(tmp);
                }
            }
        }
        double sum = 0;
        for (int[] n : next) {
            sum += dfs(n);
        }
        double res = 1.0 + sum / next.size();
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        target = Arrays.toString(sorted);
        System.out.printf("%.9f\n", dfs(arr));
    }
}
