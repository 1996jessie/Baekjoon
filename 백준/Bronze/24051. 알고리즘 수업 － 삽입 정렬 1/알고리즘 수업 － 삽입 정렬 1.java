import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 1; i < N; i++) {
            int loc = i - 1;
            int newItem = A[i];
            while (loc >= 0 && newItem < A[loc]) {
                A[loc + 1] = A[loc];
                loc--;
                count++;
                if (count == K) {
                    System.out.println(A[loc + 1]);
                    return;
                }
            }
            if (loc + 1 != i) {
                A[loc + 1] = newItem;
                count++;
                if (count == K) {
                    System.out.println(newItem);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
