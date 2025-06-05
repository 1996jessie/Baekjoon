import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        String line;
        while ((line = br.readLine()) != null) {
            for (char c : line.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    count[c - 'a']++;
                }
            }
        }

        int max = 0;
        for (int c : count) {
            if (c > max) {
                max = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] == max) {
                sb.append((char) (i + 'a'));
            }
        }

        System.out.println(sb);
    }
}
