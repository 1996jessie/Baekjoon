import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("LoveisKoreaUniversity");
            if (i < N - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
