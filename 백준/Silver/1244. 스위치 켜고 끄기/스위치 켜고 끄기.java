import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(br.readLine());
        int[] switches = new int[switchCount + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCount; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = number; j <= switchCount; j += number) {
                    switches[j] ^= 1;
                }
            } else {
                int left = number;
                int right = number;
                while (left > 1 && right < switchCount && switches[left - 1] == switches[right + 1]) {
                    left--;
                    right++;
                }
                for (int j = left; j <= right; j++) {
                    switches[j] ^= 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= switchCount; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
