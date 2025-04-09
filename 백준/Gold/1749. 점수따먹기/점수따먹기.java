import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int top = 0; top < N; top++) {
            int[] temp = new int[M];
            for (int bottom = top; bottom < N; bottom++) {
                for (int i = 0; i < M; i++) {
                    temp[i] += matrix[bottom][i];
                }
                maxSum = Math.max(maxSum, kadane(temp));
            }
        }

        System.out.println(maxSum);
    }

    static int kadane(int[] arr) {
        int max = arr[0], sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
