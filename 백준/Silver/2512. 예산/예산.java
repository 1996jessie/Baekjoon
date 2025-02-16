import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxBudget = 0;
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(maxBudget, budgets[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int left = 0, right = maxBudget, result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }

            if (sum <= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
