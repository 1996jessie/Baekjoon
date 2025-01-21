import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(countHanNumbers(N));
    }

    private static int countHanNumbers(int N) {
        if (N < 100) {
            return N;
        }

        int count = 99;
        for (int i = 100; i <= N; i++) {
            if (isHanNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isHanNumber(int num) {
        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;
        return (a - b) == (b - c);
    }
}
