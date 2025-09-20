import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine().trim());
        int x = Integer.parseInt(br.readLine().trim());
        int b = Integer.parseInt(br.readLine().trim());
        int y = Integer.parseInt(br.readLine().trim());
        int T = Integer.parseInt(br.readLine().trim());
        int over1 = Math.max(0, T - 30);
        int over2 = Math.max(0, T - 45);
        int cost1 = a + 21 * over1 * x;
        int cost2 = b + 21 * over2 * y;
        System.out.println(cost1 + " " + cost2);
    }
}
