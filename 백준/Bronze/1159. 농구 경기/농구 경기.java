import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[26];

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char firstChar = name.charAt(0);
            count[firstChar - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 5) {
                result.append((char) (i + 'a'));
            }
        }

        if (result.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(result.toString());
        }
    }
}
