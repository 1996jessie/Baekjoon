import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A1 = Integer.parseInt(st.nextToken());
            int P1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int R1 = Integer.parseInt(st.nextToken());
            int P2 = Integer.parseInt(st.nextToken());

            double sliceValue = (double) A1 / P1;
            double wholeValue = Math.PI * R1 * R1 / P2;

            if (wholeValue > sliceValue) {
                sb.append("Whole pizza\n");
            } else {
                sb.append("Slice of pizza\n");
            }
        }
        
        System.out.print(sb);
    }
}
