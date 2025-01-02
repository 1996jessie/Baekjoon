import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long N = scanner.nextLong();
        long result = (long) Math.sqrt(N);
        
        System.out.println(result);
        
        scanner.close();
    }
}
