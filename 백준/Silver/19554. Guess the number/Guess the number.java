import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int low = 1;
        int high = N;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            bw.write("? " + mid + "\n");
            bw.flush();
            int res = Integer.parseInt(br.readLine());
            if (res == 0) {
                bw.write("= " + mid + "\n");
                bw.flush();
                return;
            } else if (res == -1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
}
