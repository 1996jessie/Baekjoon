import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int[] books = new int[N];
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        int boxCount = 1, currentWeight = 0;
        for (int weight : books) {
            if (currentWeight + weight > M) {
                boxCount++;
                currentWeight = weight;
            } else {
                currentWeight += weight;
            }
        }

        System.out.println(boxCount);
    }
}
