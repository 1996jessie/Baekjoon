import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int data = 1;
            for (int j = 0; j < b; j++) {
                data *= a;
                data %= 10;
            }
            if (data == 0)
                data = 10;
            bw.write(data + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
