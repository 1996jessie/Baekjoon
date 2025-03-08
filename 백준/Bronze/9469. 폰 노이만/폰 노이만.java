import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (P-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            double D = Double.parseDouble(st.nextToken());
            double A = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            double F = Double.parseDouble(st.nextToken());

            double time = D / (A + B);
            double distance = time * F;

            sb.append(N).append(" ").append(String.format("%.6f", distance)).append("\n");
        }
        System.out.print(sb);
    }
}
