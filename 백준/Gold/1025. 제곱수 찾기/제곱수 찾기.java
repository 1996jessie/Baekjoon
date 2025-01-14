import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);
        char[][] grid = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        long maxSquare = -1;

        for (int rStart = 0; rStart < N; rStart++) {
            for (int cStart = 0; cStart < M; cStart++) {
                for (int rDiff = -N; rDiff < N; rDiff++) {
                    for (int cDiff = -M; cDiff < M; cDiff++) {
                        if (rDiff == 0 && cDiff == 0) {
                            continue;
                        }
                        
                        StringBuilder sb = new StringBuilder();
                        int r = rStart, c = cStart;

                        while (r >= 0 && r < N && c >= 0 && c < M) {
                            sb.append(grid[r][c]);
                            long num = Long.parseLong(sb.toString());
                            if (isPerfectSquare(num)) {
                                maxSquare = Math.max(maxSquare, num);
                            }
                            r += rDiff;
                            c += cDiff;
                        }
                    }
                }
            }
        }
        
        System.out.println(maxSquare);
    }

    private static boolean isPerfectSquare(long num) {
        if (num < 0) {
            return false;
        }
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
