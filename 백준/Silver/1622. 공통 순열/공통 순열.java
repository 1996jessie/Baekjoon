import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a;
        while ((a = br.readLine()) != null) {
            String b = br.readLine();
            int[] freqA = new int[26];
            int[] freqB = new int[26];
            for (int i = 0; i < a.length(); i++) {
                freqA[a.charAt(i) - 'a']++;
            }
            for (int i = 0; i < b.length(); i++) {
                freqB[b.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                int count = Math.min(freqA[i], freqB[i]);
                for (int j = 0; j < count; j++) {
                    sb.append((char) (i + 'a'));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
