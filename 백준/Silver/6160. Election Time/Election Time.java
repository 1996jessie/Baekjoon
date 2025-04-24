import java.io.*;
import java.util.*;

public class Main {
    static class Cow {
        int index;
        int firstRound;
        int secondRound;

        Cow(int index, int firstRound, int secondRound) {
            this.index = index;
            this.firstRound = firstRound;
            this.secondRound = secondRound;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Cow> cows = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cows.add(new Cow(i, A, B));
        }

        cows.sort((a, b) -> b.firstRound - a.firstRound);

        List<Cow> finalists = cows.subList(0, K);
        finalists.sort((a, b) -> b.secondRound - a.secondRound);

        System.out.println(finalists.get(0).index);
    }
}
