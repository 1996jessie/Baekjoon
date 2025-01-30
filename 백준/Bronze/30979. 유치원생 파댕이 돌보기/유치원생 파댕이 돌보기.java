import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += Integer.parseInt(st.nextToken());
        }

        if (total >= T) {
            System.out.println("Padaeng_i Happy");
        } else {
            System.out.println("Padaeng_i Cry");
        }
    }
}
