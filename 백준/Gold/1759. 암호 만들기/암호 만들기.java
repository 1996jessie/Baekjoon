import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static char[] chars;
    static char[] password;
    static String vowels = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        password = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);
        generate(0, 0, 0, 0);
    }

    static void generate(int index, int count, int vowelsCount, int consonantsCount) {
        if (count == L) {
            if (vowelsCount >= 1 && consonantsCount >= 2) {
                System.out.println(new String(password));
            }
            return;
        }
        if (index == C) {
            return;
        }

        password[count] = chars[index];
        if (vowels.indexOf(chars[index]) != -1) {
            generate(index + 1, count + 1, vowelsCount + 1, consonantsCount);
        } else {
            generate(index + 1, count + 1, vowelsCount, consonantsCount + 1);
        }
        generate(index + 1, count, vowelsCount, consonantsCount);
    }
}
