import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        long executionCount = (long) n * (n - 1) * (n - 2) / 6;
        
        System.out.println(executionCount);
        System.out.println(3);
    }
}
