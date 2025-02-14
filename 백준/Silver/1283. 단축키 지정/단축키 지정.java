import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Character> usedKeys = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean assigned = false;

            for (int j = 0; j < words.length; j++) {
                char firstChar = Character.toLowerCase(words[j].charAt(0));
                if (!usedKeys.contains(firstChar)) {
                    usedKeys.add(firstChar);
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                outer: for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char ch = Character.toLowerCase(words[j].charAt(k));
                        if (!usedKeys.contains(ch)) {
                            usedKeys.add(ch);
                            words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
                            break outer;
                        }
                    }
                }
            }

            sb.append(String.join(" ", words)).append("\n");
        }

        System.out.print(sb);
    }
}
