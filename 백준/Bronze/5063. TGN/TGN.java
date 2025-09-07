import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int profitWithAd = e - c;
            if (profitWithAd > r) {
                sb.append("advertise\n");
            } else if (profitWithAd == r) {
                sb.append("does not matter\n");
            } else {
                sb.append("do not advertise\n");
            }
        }
        System.out.print(sb.toString());
    }
}
