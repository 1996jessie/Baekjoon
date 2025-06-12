import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : S.toCharArray()) {
            sb.append(c).append('#');
        }
        String T = sb.toString();
        int[] p = new int[T.length()];
        int center = 0, right = 0, maxLen = 0;
        for (int i = 0; i < T.length(); i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < T.length() && T.charAt(i - p[i] - 1) == T.charAt(i + p[i] + 1)) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if (p[i] > maxLen) {
                maxLen = p[i];
            }
        }
        System.out.println(maxLen);
    }
}
