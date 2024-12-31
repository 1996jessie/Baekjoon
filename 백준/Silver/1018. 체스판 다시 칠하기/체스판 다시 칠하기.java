import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        
        char[][] board = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }
        
        int minChanges = Integer.MAX_VALUE;
        
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int changes1 = 0;
                int changes2 = 0;
                
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if ((x + y) % 2 == 0) {
                            if (board[i + x][j + y] != 'W') {
                                changes1++;
                            }
                            if (board[i + x][j + y] != 'B') {
                                changes2++;
                            }
                        } else {
                            if (board[i + x][j + y] != 'B') {
                                changes1++;
                            }
                            if (board[i + x][j + y] != 'W') {
                                changes2++;
                            }
                        }
                    }
                }
                
                minChanges = Math.min(minChanges, Math.min(changes1, changes2));
            }
        }
        
        System.out.println(minChanges);
    }
}
