import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] correctPieces = {1, 1, 2, 2, 2, 8};
        int[] currentPieces = new int[6];
        
        for (int i = 0; i < 6; i++) {
            currentPieces[i] = sc.nextInt();
        }
        
        for (int i = 0; i < 6; i++) {
            System.out.print(correctPieces[i] - currentPieces[i] + " ");
        }
    }
}
