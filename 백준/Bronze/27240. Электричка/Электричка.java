import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st2.nextToken());
        int t = Integer.parseInt(st2.nextToken());

        if (s > t) {
            int temp = s;
            s = t;
            t = temp;
        }

        if (s > a && t < b) {
            System.out.println("City");
        } else if ((s <= a && t <= a) || (s >= b && t >= b)) {
            System.out.println("Outside");
        } else {
            System.out.println("Full");
        }
    }
}
