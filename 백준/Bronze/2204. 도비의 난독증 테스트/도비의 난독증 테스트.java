import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }

            String result = Arrays.stream(words)
                    .min((a, b) -> a.toLowerCase().compareTo(b.toLowerCase()))
                    .get();

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
