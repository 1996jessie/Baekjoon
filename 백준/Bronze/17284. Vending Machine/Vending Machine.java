import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int money = 5000;
        while (st.hasMoreTokens()) {
            int btn = Integer.parseInt(st.nextToken());
            if (btn == 1) money -= 500;
            else if (btn == 2) money -= 800;
            else if (btn == 3) money -= 1000;
        }
        System.out.println(money);
    }
}
