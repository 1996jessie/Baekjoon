import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        sc.nextLine();
        
        for (int t = 0; t < T; t++) {
            String[] input = sc.nextLine().split(" ");
            int R = Integer.parseInt(input[0]);
            String S = input[1];
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                for (int j = 0; j < R; j++) {
                    result.append(S.charAt(i));
                }
            }
            System.out.println(result);
        }
    }
}
