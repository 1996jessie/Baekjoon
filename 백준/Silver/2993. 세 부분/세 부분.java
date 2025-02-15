import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int len = word.length();
        String result = "z".repeat(len);

        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String part1 = new StringBuilder(word.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(word.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(word.substring(j)).reverse().toString();
                String combined = part1 + part2 + part3;
                if (combined.compareTo(result) < 0) {
                    result = combined;
                }
            }
        }

        System.out.println(result);
    }
}
