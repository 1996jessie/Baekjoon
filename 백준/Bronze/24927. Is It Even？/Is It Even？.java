import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int countTwos = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            while (x % 2 == 0) {
                countTwos++;
                x /= 2;
            }
        }

        System.out.println(countTwos >= K ? 1 : 0);
    }
}
