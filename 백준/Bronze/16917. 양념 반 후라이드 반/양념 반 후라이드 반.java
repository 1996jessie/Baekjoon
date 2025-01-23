import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        int X = Integer.parseInt(input[3]);
        int Y = Integer.parseInt(input[4]);

        int result = Integer.MAX_VALUE;

        int maxCount = Math.max(X, Y);
        for (int half = 0; half <= 2 * maxCount; half += 2) {
            int fullHalfPrice = half * C;
            int remainingA = Math.max(0, X - half / 2);
            int remainingB = Math.max(0, Y - half / 2);
            int fullPrice = fullHalfPrice + remainingA * A + remainingB * B;

            result = Math.min(result, fullPrice);
        }

        System.out.println(result);
    }
}
