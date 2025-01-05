import java.io.*;
import java.util.*;

public class Main {
    static int white = 0, blue = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        divideAndConquer(paper, 0, 0, N);
        
        System.out.println(white);
        System.out.println(blue);
    }
    
    public static void divideAndConquer(int[][] paper, int x, int y, int size) {
        if (isSameColor(paper, x, y, size)) {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        
        int newSize = size / 2;
        divideAndConquer(paper, x, y, newSize);
        divideAndConquer(paper, x, y + newSize, newSize);
        divideAndConquer(paper, x + newSize, y, newSize);
        divideAndConquer(paper, x + newSize, y + newSize, newSize);
    }
    
    public static boolean isSameColor(int[][] paper, int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
