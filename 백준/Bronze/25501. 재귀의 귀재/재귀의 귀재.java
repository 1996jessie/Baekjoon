import java.io.*;

public class Main {
    static int callCount;

    public static int recursion(String s, int l, int r) {
        callCount++;
        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            return recursion(s, l + 1, r - 1);
        }
    }

    public static int isPalindrome(String s) {
        callCount = 0;
        return recursion(s, 0, s.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String S = br.readLine();
            int result = isPalindrome(S);
            System.out.println(result + " " + callCount);
        }
    }
}
