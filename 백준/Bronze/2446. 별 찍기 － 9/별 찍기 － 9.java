import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            printLine(i, 2 * (N - i) - 1);
        }
        for (int i = N - 2; i >= 0; i--) {
            printLine(i, 2 * (N - i) - 1);
        }
    }

    private static void printLine(int spaces, int stars) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
