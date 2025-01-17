import java.io.*;
import java.util.*;

public class Main {
    static List<String>[][] dp = new List[2][20];
    static int len, k;
    static boolean check;
    static String n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        k = Integer.parseInt(n.split(" ")[1]);
        n = n.split(" ")[0];

        for (int i = 0; i < 20; i++) {
            dp[0][i] = new ArrayList<>();
            dp[1][i] = new ArrayList<>();
            for (int j = 0; j < (1 << 11); j++) {
                dp[0][i].add("");
                dp[1][i].add("");
            }
        }

        len = Math.max(k, n.length());
        System.out.println(recur(k > n.length(), 0, 0, 0));
    }

    static String recur(boolean big, int index, int bit, int dif) {
        if (index == len) {
            if (dif == k) check = true;
            else check = false;

            return dp[big ? 1 : 0][index].get(bit);
        }

        if (!dp[big ? 1 : 0][index].get(bit).equals("")) {
            return dp[big ? 1 : 0][index].get(bit);
        }

        String result = "";
        for (int i = (big ? (index == 0 ? 1 : 0) : n.charAt(index) - '0'); i < 10; i++) {
            int newBit = bit | (1 << i);
            int newDif = (bit & (1 << i)) != 0 ? dif : dif + 1;
            String current = i + recur(big || i > (n.charAt(index) - '0'), index + 1, newBit, newDif);

            result = current;
            dp[big ? 1 : 0][index].set(bit, result);

            if (check) return result;
        }

        if (index == 0) {
            len++;
            result = "1" + recur(true, index + 1, 1 << 1, 1);
            dp[big ? 1 : 0][index].set(bit, result);
        }

        return result;
    }
}
