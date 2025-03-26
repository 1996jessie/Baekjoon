import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int sum = S + K + H;
        if (sum >= 100) {
            System.out.println("OK");
        } else {
            if (S < K && S < H) {
                System.out.println("Soongsil");
            } else if (K < S && K < H) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
    }
}
