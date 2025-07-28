import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] guitars = new long[N];
        for (int i = 0; i < N; i++) {
            sc.next();
            String s = sc.next();
            long mask = 0;
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'Y') {
                    mask |= (1L << j);
                }
            }
            guitars[i] = mask;
        }
        int maxSongs = 0;
        int minGuitars = Integer.MAX_VALUE;
        for (int subset = 1; subset < (1 << N); subset++) {
            long combined = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if ((subset & (1 << i)) != 0) {
                    combined |= guitars[i];
                    count++;
                }
            }
            int songs = Long.bitCount(combined);
            if (songs > maxSongs) {
                maxSongs = songs;
                minGuitars = count;
            } else if (songs == maxSongs && count < minGuitars) {
                minGuitars = count;
            }
        }
        System.out.println(maxSongs == 0 ? -1 : minGuitars);
    }
}
