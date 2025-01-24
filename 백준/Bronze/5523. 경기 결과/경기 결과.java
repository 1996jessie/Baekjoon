import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int aWins = 0, bWins = 0;

        for (int i = 0; i < N; i++) {
            String[] scores = br.readLine().split(" ");
            int A = Integer.parseInt(scores[0]);
            int B = Integer.parseInt(scores[1]);

            if (A > B) {
                aWins++;
            } else if (B > A) {
                bWins++;
            }
        }

        System.out.println(aWins + " " + bWins);
    }
}
