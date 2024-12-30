import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] croatianAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;
        int i = 0;

        while (i < input.length()) {
            boolean matched = false;
            for (String ca : croatianAlphabet) {
                if (i + ca.length() <= input.length() && input.substring(i, i + ca.length()).equals(ca)) {
                    count++;
                    i += ca.length();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                count++;
                i++;
            }
        }

        System.out.println(count);
    }
}
