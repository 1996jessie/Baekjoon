import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int dSize = Integer.parseInt(st.nextToken());
        int mSize = Integer.parseInt(st.nextToken());
        
        int[] d = new int[dSize];
        int[] m = new int[mSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dSize; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mSize; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        int lcm = d[0];
        for (int i = 1; i < dSize; i++) {
            lcm = getLCM(lcm, d[i]);
        }

        int gcd = m[0];
        for (int i = 1; i < mSize; i++) {
            gcd = getGCD(gcd, m[i]);
        }

        int count = 0;
        for (int i = lcm; i <= gcd; i += lcm) {
            if (gcd % i == 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int getLCM(int a, int b) {
        return a / getGCD(a, b) * b;
    }
}
