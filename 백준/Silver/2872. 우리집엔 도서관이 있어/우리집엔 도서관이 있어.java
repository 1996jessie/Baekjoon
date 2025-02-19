import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] books = new int[N];

        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(br.readLine());
        }

        int maxSeq = 0;
        int target = N;

        for (int i = N - 1; i >= 0; i--) {
            if (books[i] == target) {
                maxSeq++;
                target--;
            }
        }

        System.out.println(N - maxSeq);
    }
}
