import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        
        if (sides[0] + sides[1] > sides[2]) {
            System.out.println(a + b + c);
        } else {
            System.out.println(2 * (sides[0] + sides[1]) - 1);
        }
        
        sc.close();
    }
}
