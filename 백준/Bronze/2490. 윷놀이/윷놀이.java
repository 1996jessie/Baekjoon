import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int zeroCount = 0;
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) zeroCount++;
            }
            switch (zeroCount) {
                case 1: sb.append("A\n"); break;
                case 2: sb.append("B\n"); break;
                case 3: sb.append("C\n"); break;
                case 4: sb.append("D\n"); break;
                case 0: sb.append("E\n"); break;
            }
        }
        System.out.print(sb);
    }
}
