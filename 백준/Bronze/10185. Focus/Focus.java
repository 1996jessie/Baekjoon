import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double p = Double.parseDouble(st.nextToken());
            double q = Double.parseDouble(st.nextToken());
            double f = 1 / ((1 / p) + (1 / q));
            System.out.printf("f = %.1f\n", f);
        }
    }
}
