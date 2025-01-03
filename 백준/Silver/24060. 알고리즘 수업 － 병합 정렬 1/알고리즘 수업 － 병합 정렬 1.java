import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int count = 0;

    public static void mergeSort(int[] A, int[] tmp, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, tmp, p, q);
            mergeSort(A, tmp, q + 1, r);
            merge(A, A, tmp, p, q, r);
        }
    }

    public static void merge(int[] A, int[] tmp, int[] tmpArr, int p, int q, int r) {
        int i = p, j = q + 1, t = p;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmpArr[t++] = A[i++];
            } else {
                tmpArr[t++] = A[j++];
            }
            if (++count == K) {
                System.out.println(tmpArr[t - 1]);
                System.exit(0);
            }
        }

        while (i <= q) {
            tmpArr[t++] = A[i++];
            if (++count == K) {
                System.out.println(tmpArr[t - 1]);
                System.exit(0);
            }
        }

        while (j <= r) {
            tmpArr[t++] = A[j++];
            if (++count == K) {
                System.out.println(tmpArr[t - 1]);
                System.exit(0);
            }
        }

        for (i = p; i <= r; i++) {
            A[i] = tmpArr[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] tmp = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(A, tmp, 0, N - 1);

        System.out.println(-1);
    }
}
