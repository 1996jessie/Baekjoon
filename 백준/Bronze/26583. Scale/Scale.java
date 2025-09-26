import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(" ");
            int n = parts.length;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            for (int i = 0; i < n; i++) {
                int val;
                if (n == 1) {
                    val = nums[i];
                } else if (i == 0) {
                    val = nums[i] * nums[i + 1];
                } else if (i == n - 1) {
                    val = nums[i] * nums[i - 1];
                } else {
                    val = nums[i] * nums[i - 1] * nums[i + 1];
                }
                sb.append(val);
                if (i < n - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
