import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        
        int diagonal = 1;
        int sum = 1;
        
        while (X > sum) {
            diagonal++;
            sum += diagonal;
        }
        
        int diff = sum - X;
        int numerator, denominator;
        
        if (diagonal % 2 == 0) {
            numerator = diagonal - diff;
            denominator = 1 + diff;
        } else {
            numerator = 1 + diff;
            denominator = diagonal - diff;
        }
        
        System.out.println(numerator + "/" + denominator);
    }
}
