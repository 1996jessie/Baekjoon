import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String A = br.readLine();
        String B = br.readLine();

        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        for (int i = 0; i <= N - K; i++) {
            setA.add(A.substring(i, i + K));
            setB.add(B.substring(i, i + K));
        }

        setA.retainAll(setB);

        System.out.println(setA.size());
    }
}
