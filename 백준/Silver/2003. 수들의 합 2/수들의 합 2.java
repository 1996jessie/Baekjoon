import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(secondLine[i]);
        }

        int count = 0, sum = 0, left = 0;
        for (int right = 0; right < N; right++) {
            sum += A[right];
            while (sum > M) {
                sum -= A[left++];
            }
            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}
