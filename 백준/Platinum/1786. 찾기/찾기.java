import java.io.*;
import java.util.*;

public class Main {

    static String T, P;
    static int[] pi;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        P = br.readLine();
        
        pi = new int[P.length()];
        computePrefixFunction();

        kmpSearch();

        System.out.println(result.size());
        for (int idx : result) {
            System.out.print((idx + 1) + " ");
        }
    }

    static void computePrefixFunction() {
        int m = P.length();
        int j = 0;
        
        for (int i = 1; i < m; i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
    }

    static void kmpSearch() {
        int n = T.length();
        int m = P.length();
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (T.charAt(i) == P.charAt(j)) {
                j++;
            }
            if (j == m) {
                result.add(i - m + 1);
                j = pi[j - 1];
            }
        }
    }
}
