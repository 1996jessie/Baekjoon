import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        long costA = (long)(U / 100) * X;
        long costB = (long)(V / 50) * Y;
        long costC = (long)(W / 20) * Z;
        System.out.println(costA + costB + costC);
    }
}
