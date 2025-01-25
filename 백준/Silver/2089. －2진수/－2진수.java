import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        if (N == 0) {
            System.out.println(0);
            return;
        }

        while (N != 0) {
            int remainder = N % -2;
            N /= -2;

            if (remainder < 0) {
                remainder += 2;
                N += 1;
            }

            result.append(remainder);
        }

        System.out.println(result.reverse().toString());
    }
}
