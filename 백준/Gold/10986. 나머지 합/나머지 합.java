import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        
        String[] arrayStr = br.readLine().split(" ");
        long[] A = new long[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(arrayStr[i]);
        }

        long[] modCount = new long[M];
        modCount[0] = 1;

        long currentSum = 0;
        long result = 0;

        for (int i = 0; i < N; i++) {
            currentSum += A[i];
            int mod = (int)((currentSum % M + M) % M);

            result += modCount[mod];
            modCount[mod]++;
        }

        System.out.println(result);
    }
}

