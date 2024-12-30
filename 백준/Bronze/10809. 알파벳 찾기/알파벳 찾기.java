import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        
        for (char c = 'a'; c <= 'z'; c++) {
            int index = S.indexOf(c);
            System.out.print(index + " ");
        }
    }
}
