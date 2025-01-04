import java.io.*;

public class Main {
    static int[][] board = new int[9][9];
    static boolean[][] rowCheck = new boolean[9][10];
    static boolean[][] colCheck = new boolean[9][10];
    static boolean[][] boxCheck = new boolean[9][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] != 0) {
                    rowCheck[i][board[i][j]] = true;
                    colCheck[j][board[i][j]] = true;
                    boxCheck[(i / 3) * 3 + (j / 3)][board[i][j]] = true;
                }
            }
        }

        solve(0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solve(int row, int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solve(row + 1, 0);
        }

        if (board[row][col] != 0) {
            return solve(row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            if (!rowCheck[row][num] && !colCheck[col][num] && !boxCheck[(row / 3) * 3 + (col / 3)][num]) {
                board[row][col] = num;
                rowCheck[row][num] = true;
                colCheck[col][num] = true;
                boxCheck[(row / 3) * 3 + (col / 3)][num] = true;

                if (solve(row, col + 1)) {
                    return true;
                }

                board[row][col] = 0;
                rowCheck[row][num] = false;
                colCheck[col][num] = false;
                boxCheck[(row / 3) * 3 + (col / 3)][num] = false;
            }
        }

        return false;
    }
}
