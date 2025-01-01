import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        List<String> sortedWords = new ArrayList<>(words);

        Collections.sort(sortedWords, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return Integer.compare(a.length(), b.length());
            }
        });

        for (String word : sortedWords) {
            bw.write(word + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
