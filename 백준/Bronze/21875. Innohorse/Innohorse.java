import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int x1 = a.charAt(0) - 'a' + 1;
        int y1 = a.charAt(1) - '1' + 1;
        int x2 = b.charAt(0) - 'a' + 1;
        int y2 = b.charAt(1) - '1' + 1;

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int x = Math.min(dx, dy);
        int y = Math.max(dx, dy);

        System.out.println(x + " " + y);
    }
}
