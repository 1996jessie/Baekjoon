import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long Y = 0;
        long bitPos = 1;

        while (K > 0) {
            if ((X & bitPos) == 0) {
                if ((K & 1) == 1) {
                    Y |= bitPos;
                }
                K >>= 1;
            }
            bitPos <<= 1;
        }

        System.out.println(Y);
    }
}
