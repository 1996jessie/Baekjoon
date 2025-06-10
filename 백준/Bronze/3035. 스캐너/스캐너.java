import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());

        String[] newspaper = new String[R];
        for (int i = 0; i < R; i++) {
            newspaper[i] = br.readLine();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < R; i++) {
            for (int zr = 0; zr < ZR; zr++) {
                for (int j = 0; j < C; j++) {
                    char ch = newspaper[i].charAt(j);
                    for (int zc = 0; zc < ZC; zc++) {
                        bw.write(ch);
                    }
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
