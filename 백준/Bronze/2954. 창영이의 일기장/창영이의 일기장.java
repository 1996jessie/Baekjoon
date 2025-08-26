import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < line.length()) {
            char c = line.charAt(i);
            sb.append(c);
            if (isVowel(c)) {
                i += 3;
            } else {
                i += 1;
            }
        }
        System.out.println(sb.toString());
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
