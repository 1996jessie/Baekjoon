import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int maxLength = 0, open = 0, close = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                maxLength = Math.max(maxLength, open * 2);
            } else if (close > open) {
                open = close = 0;
            }
        }

        open = close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                close++;
            } else {
                open++;
            }
            if (open == close) {
                maxLength = Math.max(maxLength, open * 2);
            } else if (open > close) {
                open = close = 0;
            }
        }

        System.out.println(maxLength);
    }
}
