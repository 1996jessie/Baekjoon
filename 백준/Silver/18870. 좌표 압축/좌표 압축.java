import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] X = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedX = X.clone();
        Arrays.sort(sortedX);
        
        Map<Integer, Integer> compression = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (!compression.containsKey(sortedX[i])) {
                compression.put(sortedX[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(compression.get(X[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}
