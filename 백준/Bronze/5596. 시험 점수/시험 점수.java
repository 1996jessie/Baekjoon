import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int s = 0;
        int t = 0;
        for (int i = 0; i < 4; i++) {
            s += Integer.parseInt(st1.nextToken());
        }
        for (int i = 0; i < 4; i++) {
            t += Integer.parseInt(st2.nextToken());
        }
        System.out.println(Math.max(s, t));
    }
}
