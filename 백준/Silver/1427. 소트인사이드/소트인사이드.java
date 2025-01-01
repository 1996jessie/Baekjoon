import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        char[] digits = N.toCharArray();
        Arrays.sort(digits);

        StringBuilder sb = new StringBuilder(new String(digits));
        System.out.println(sb.reverse().toString());

        br.close();
    }
}
