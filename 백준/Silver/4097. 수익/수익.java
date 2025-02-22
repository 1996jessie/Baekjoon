import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int maxSum = Integer.MIN_VALUE;
            int currentSum = 0;

            for (int i = 0; i < N; i++) {
                int P = Integer.parseInt(br.readLine());

                if (currentSum < 0) {
                    currentSum = P;
                } else {
                    currentSum += P;
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }

            sb.append(maxSum).append("\n");
        }

        System.out.print(sb);
    }
}
