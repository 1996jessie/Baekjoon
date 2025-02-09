import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int P = sc.nextInt();

        List<Integer> sequence = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        int current = A;
        int index = 0;
        
        while (!indexMap.containsKey(current)) {
            indexMap.put(current, index);
            sequence.add(current);
            current = getNextNumber(current, P);
            index++;
        }

        int cycleStartIndex = indexMap.get(current);
        System.out.println(cycleStartIndex);
    }

    private static int getNextNumber(int num, int P) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow(num % 10, P);
            num /= 10;
        }
        return sum;
    }
}
