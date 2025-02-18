import java.io.*;
import java.util.*;

public class Main {
    static int digitSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] serials = new String[N];

        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, (a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            int sumA = digitSum(a);
            int sumB = digitSum(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return a.compareTo(b);
        });

        for (String s : serials) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
