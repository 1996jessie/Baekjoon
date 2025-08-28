import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char L = st.nextToken().charAt(0);

        int count = 0;
        int num = 0;
        while (count < N) {
            num++;
            if (Integer.toString(num).indexOf(L) == -1) {
                count++;
            }
        }
        bw.write(num + "\n");
        bw.flush();
    }
}
