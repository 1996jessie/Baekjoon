import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, a*b + c*d);
        ans = Math.max(ans, a*c + b*d);
        ans = Math.max(ans, a*d + b*c);
        System.out.println(ans);
    }
}
