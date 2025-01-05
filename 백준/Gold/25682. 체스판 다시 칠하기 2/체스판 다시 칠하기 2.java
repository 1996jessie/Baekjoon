import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        int[][] whiteChanges = new int[N+1][M+1];
        int[][] blackChanges = new int[N+1][M+1];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char current = board[i][j];
                if ((i + j) % 2 == 0) {
                    if (current != 'W') {
                        whiteChanges[i+1][j+1]++;
                    }
                    if (current != 'B') {
                        blackChanges[i+1][j+1]++;
                    }
                } else {
                    if (current != 'B') {
                        whiteChanges[i+1][j+1]++;
                    }
                    if (current != 'W') {
                        blackChanges[i+1][j+1]++;
                    }
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i > 0) {
                    whiteChanges[i][j] += whiteChanges[i-1][j];
                }
                if (j > 0) {
                    whiteChanges[i][j] += whiteChanges[i][j-1];
                }
                if (i > 0 && j > 0) {
                    whiteChanges[i][j] -= whiteChanges[i-1][j-1];
                }

                if (i > 0) {
                    blackChanges[i][j] += blackChanges[i-1][j];
                }
                if (j > 0) {
                    blackChanges[i][j] += blackChanges[i][j-1];
                }
                if (i > 0 && j > 0) {
                    blackChanges[i][j] -= blackChanges[i-1][j-1];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int whiteCost = whiteChanges[i][j] 
                                - whiteChanges[i-K][j] 
                                - whiteChanges[i][j-K] 
                                + whiteChanges[i-K][j-K];
                int blackCost = blackChanges[i][j] 
                                - blackChanges[i-K][j] 
                                - blackChanges[i][j-K] 
                                + blackChanges[i-K][j-K];
                result = Math.min(result, Math.min(whiteCost, blackCost));
            }
        }

        System.out.println(result);
    }
}

