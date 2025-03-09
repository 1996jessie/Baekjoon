import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] count = new int[10];

        for (char c : N.toCharArray()) {
            count[c - '0']++;
        }

        int sixNine = (count[6] + count[9] + 1) / 2;
        count[6] = count[9] = sixNine;

        int maxSet = 0;
        for (int i = 0; i < 10; i++) {
            maxSet = Math.max(maxSet, count[i]);
        }

        System.out.println(maxSet);
    }
}
