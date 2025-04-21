import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String score = br.readLine();
        int len = score.length();
        int half = len / 2;

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < half; i++) {
            leftSum += score.charAt(i) - '0';
        }

        for (int i = half; i < len; i++) {
            rightSum += score.charAt(i) - '0';
        }

        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
