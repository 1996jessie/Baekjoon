import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mary = 0;
            int john = 0;
            for (int i = 0; i < N; i++) {
                int r = Integer.parseInt(st.nextToken());
                if (r == 0) {
                    mary++;
                } else {
                    john++;
                }
            }
            System.out.println("Mary won " + mary + " times and John won " + john + " times");
        }
    }
}
