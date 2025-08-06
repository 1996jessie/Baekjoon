import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = 0, m = 0;

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            y += (t / 30 + 1) * 10;
            m += (t / 60 + 1) * 15;
        }

        if (y < m) {
            System.out.println("Y " + y);
        } else if (m < y) {
            System.out.println("M " + m);
        } else {
            System.out.println("Y M " + y);
        }
    }
}
