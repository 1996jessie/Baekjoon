import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);
        int N = Integer.parseInt(input[3]);

        for (int i = 0; i <= N / A; i++) {
            for (int j = 0; j <= N / B; j++) {
                int rem = N - (A * i + B * j);
                if (rem < 0) {
                    continue;
                }
                if (rem % C == 0) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
