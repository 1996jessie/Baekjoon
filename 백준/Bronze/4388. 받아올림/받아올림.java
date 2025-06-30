import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (a.equals("0") && b.equals("0")) {
                break;
            }

            int maxLen = Math.max(a.length(), b.length());
            a = "0".repeat(maxLen - a.length()) + a;
            b = "0".repeat(maxLen - b.length()) + b;

            int carry = 0;
            int count = 0;

            for (int i = maxLen - 1; i >= 0; i--) {
                int digitA = a.charAt(i) - '0';
                int digitB = b.charAt(i) - '0';
                int sum = digitA + digitB + carry;
                if (sum >= 10) {
                    carry = 1;
                    count++;
                } else {
                    carry = 0;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
