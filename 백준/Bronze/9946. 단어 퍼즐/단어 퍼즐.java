import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original, recovered;
        int caseNum = 1;

        while (true) {
            original = br.readLine();
            recovered = br.readLine();
            if (original.equals("END") && recovered.equals("END")) {
                break;
            }

            int[] count1 = new int[26];
            int[] count2 = new int[26];

            for (char c : original.toCharArray()) {
                count1[c - 'a']++;
            }

            for (char c : recovered.toCharArray()) {
                count2[c - 'a']++;
            }

            boolean same = true;
            for (int i = 0; i < 26; i++) {
                if (count1[i] != count2[i]) {
                    same = false;
                    break;
                }
            }

            System.out.println("Case " + caseNum + ": " + (same ? "same" : "different"));
            caseNum++;
        }
    }
}
