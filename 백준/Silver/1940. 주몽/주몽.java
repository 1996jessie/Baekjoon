import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] materials = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(materials);
        int left = 0, right = N - 1, count = 0;
        while (left < right) {
            int sum = materials[left] + materials[right];
            if (sum == M) {
                count++;
                left++;
                right--;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}
