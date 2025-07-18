import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double total = 0.0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double q = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            total += q * y;
        }
        System.out.printf("%.3f\n", total);
    }
}
