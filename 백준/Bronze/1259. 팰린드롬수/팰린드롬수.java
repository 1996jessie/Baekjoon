import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }
            sb.append(isPalindrome(num) ? "yes\n" : "no\n");
        }
        System.out.print(sb);
    }

    static boolean isPalindrome(String num) {
        int len = num.length();
        for (int i = 0; i < len / 2; i++) {
            if (num.charAt(i) != num.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
