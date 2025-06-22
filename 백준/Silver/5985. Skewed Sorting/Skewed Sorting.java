import java.util.*;

public class Main {
    static int totalDistance = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int size = 1 << N;
        int[] cows = new int[size];
        for (int i = 0; i < size; i++) {
            cows[i] = sc.nextInt();
        }

        sortAndCount(cows, 0, size);

        System.out.println(totalDistance);
        for (int cow : cows) {
            System.out.println(cow);
        }
    }

    static void sortAndCount(int[] arr, int l, int r) {
        if (r - l <= 1) return;

        int m = (l + r) / 2;
        sortAndCount(arr, l, m);
        sortAndCount(arr, m, r);

        boolean needSwap = false;
        for (int i = 0; i < m - l; i++) {
            if (arr[m + i] < arr[l + i]) {
                needSwap = true;
                break;
            } else if (arr[m + i] > arr[l + i]) {
                break;
            }
        }

        if (needSwap) {
            for (int i = 0; i < m - l; i++) {
                int temp = arr[l + i];
                arr[l + i] = arr[m + i];
                arr[m + i] = temp;
                totalDistance += (m - l) * 2;
            }
        }
    }
}
