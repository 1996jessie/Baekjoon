import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append("danger\n");
                continue;
            }
            int[] lengths = new int[n];
            for (int i = 0; i < n; i++) {
                lengths[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(lengths);
            int left = 0, right = n - 1;
            int bestL1 = 0, bestL2 = 0, maxDiff = -1;
            while (left < right) {
                int sum = lengths[left] + lengths[right];
                if (sum == x) {
                    int diff = Math.abs(lengths[left] - lengths[right]);
                    if (diff > maxDiff) {
                        maxDiff = diff;
                        bestL1 = lengths[left];
                        bestL2 = lengths[right];
                    }
                    left++;
                    right--;
                } else if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }
            if (maxDiff == -1) {
                sb.append("danger\n");
            } else {
                sb.append("yes ").append(bestL1).append(" ").append(bestL2).append("\n");
            }
        }
        System.out.print(sb);
    }
}
