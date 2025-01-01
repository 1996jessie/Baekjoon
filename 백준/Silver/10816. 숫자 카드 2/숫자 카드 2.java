import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> cardCount = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            result.append(cardCount.getOrDefault(query, 0)).append(" ");
        }

        System.out.println(result.toString().trim());
        br.close();
    }
}
