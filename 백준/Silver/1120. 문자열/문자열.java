import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String A = input[0], B = input[1];
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= B.length() - A.length(); i++) {
            int diff = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    diff++;
                }
            }
            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
        br.close();
    }
}
