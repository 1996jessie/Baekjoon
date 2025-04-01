import java.io.*;
import java.util.*;

public class Main {
    static int S, C;
    static long[] greenOnions;

    static boolean isPossible(long length) {
        long totalPieces = 0;
        for (long l : greenOnions) {
            totalPieces += (l / length);
            if (totalPieces >= C) return true;
        }
        return totalPieces >= C;
    }

    static long binarySearch() {
        long left = 1, right = Arrays.stream(greenOnions).max().getAsLong();
        long bestLength = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(mid)) {
                bestLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bestLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        greenOnions = new long[S];

        long totalLength = 0;
        for (int i = 0; i < S; i++) {
            greenOnions[i] = Long.parseLong(br.readLine());
            totalLength += greenOnions[i];
        }

        long maxOnionLength = binarySearch();
        long usedOnion = maxOnionLength * C;
        System.out.println(totalLength - usedOnion);
    }
}
