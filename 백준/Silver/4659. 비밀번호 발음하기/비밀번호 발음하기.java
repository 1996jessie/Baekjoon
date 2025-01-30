import java.io.*;

public class Main {
    static String vowels = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String password;

        while (!(password = br.readLine()).equals("end")) {
            if (isValid(password)) {
                sb.append("<").append(password).append("> is acceptable.\n");
            } else {
                sb.append("<").append(password).append("> is not acceptable.\n");
            }
        }
        System.out.print(sb);
    }

    static boolean isValid(String pw) {
        boolean hasVowel = false;
        int vowelCount = 0, consonantCount = 0;
        char prevChar = 0;

        for (char c : pw.toCharArray()) {
            boolean isVowel = vowels.indexOf(c) != -1;

            if (isVowel) {
                hasVowel = true;
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            if (vowelCount == 3 || consonantCount == 3) {
                return false;
            }

            if (prevChar == c && c != 'e' && c != 'o') {
                return false;
            }

            prevChar = c;
        }
        return hasVowel;
    }
}
