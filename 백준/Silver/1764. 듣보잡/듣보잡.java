import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> heard = new HashSet<>();
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            heard.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            seen.add(br.readLine());
        }

        heard.retainAll(seen);
        
        List<String> result = new ArrayList<>(heard);
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
