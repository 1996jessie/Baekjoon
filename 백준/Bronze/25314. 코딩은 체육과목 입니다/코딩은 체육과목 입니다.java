import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int count = N / 4;
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append("long ");
        }
        
        result.append("int");
        
        System.out.println(result.toString());
        
        sc.close();
    }
}
