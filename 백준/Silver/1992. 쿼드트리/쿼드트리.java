import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] paper = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            paper[i] = br.readLine().toCharArray();
        }
        
        System.out.println(compress(paper, 0, 0, N));
    }
    
    public static String compress(char[][] paper, int x, int y, int size) {
        if (isUniform(paper, x, y, size)) {
            return String.valueOf(paper[x][y]);
        }

        int newSize = size / 2;
        String topLeft = compress(paper, x, y, newSize);
        String topRight = compress(paper, x, y + newSize, newSize);
        String bottomLeft = compress(paper, x + newSize, y, newSize);
        String bottomRight = compress(paper, x + newSize, y + newSize, newSize);

        return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
    }
    
    public static boolean isUniform(char[][] paper, int x, int y, int size) {
        char value = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
