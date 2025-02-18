import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        do {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        } while (nextPermutation(arr));
        System.out.print(sb);
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }
        swap(arr, i - 1, j);
        j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
        return true;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
