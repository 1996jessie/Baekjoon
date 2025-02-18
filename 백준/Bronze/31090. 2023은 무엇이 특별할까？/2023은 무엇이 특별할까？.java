import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int lastTwoDigits = N % 100;
            int nextYear = N + 1;

            if (nextYear % lastTwoDigits == 0) {
                sb.append("Good\n");
            } else {
                sb.append("Bye\n");
            }
        }

        System.out.print(sb);
    }
}
