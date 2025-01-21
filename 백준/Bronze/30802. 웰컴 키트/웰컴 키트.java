import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long N = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] shirtSizes = new long[6];
        for (int i = 0; i < 6; i++) {
            shirtSizes[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long T = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());

        long totalShirtBundles = 0;
        for (long sizeCount : shirtSizes) {
            totalShirtBundles += (sizeCount + T - 1) / T;
        }
        System.out.println(totalShirtBundles);

        long penBundles = N / P;
        long singlePens = N % P;
        System.out.println(penBundles + " " + singlePens);
    }
}
