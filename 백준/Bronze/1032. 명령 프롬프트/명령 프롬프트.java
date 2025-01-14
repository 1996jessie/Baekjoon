import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        String[] files = new String[N];
        
        for (int i = 0; i < N; i++) {
            files[i] = sc.nextLine();
        }
        
        int length = files[0].length();
        StringBuilder pattern = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            char currentChar = files[0].charAt(i);
            boolean isSame = true;
            
            for (int j = 1; j < N; j++) {
                if (files[j].charAt(i) != currentChar) {
                    isSame = false;
                    break;
                }
            }
            
            if (isSame) {
                pattern.append(currentChar);
            } else {
                pattern.append('?');
            }
        }
        
        System.out.println(pattern.toString());
    }
}
