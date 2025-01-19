import java.io.*;
import java.util.*;

public class Main {
    static int[] origin, array;
    static int N;
    static Interval first, second;
     
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
         
        N = sc.nextInt();
        origin = new int[N + 1];
         
        for (int i = 1; i <= N; i++) {
            origin[i] = sc.nextInt();
        }
     
        first = new Interval();
        second = new Interval();
         
        if (!front()) {
            first.reset(); 
            second.reset();
            back();
        }
         
        System.out.println(first.x + " " + first.y);
        System.out.println(second.x + " " + second.y);
    }

    private static boolean front() {
        array = origin.clone();
        int reverseCnt = 0;

        for (int i = 1; i <= N; i++) {
            if (array[i] != i) {
                int s = i;
                int e = N;
                for (int j = i + 1; j <= N; j++) {
                    if (array[j] == i) {
                        e = j;
                        break;
                    }
                }
                reverse(s, e);
                reverseCnt++;

                if (reverseCnt == 1) {
                    first.x = s; 
                    first.y = e;
                } else if (reverseCnt == 2) {
                    second.x = s;
                    second.y = e;
                }
            }
            if (reverseCnt >= 3) {
                break;
            }
        }
        return reverseCnt <= 2;
    }
     
    private static boolean back() {
        array = origin.clone();
        int reverseCnt = 0;

        for (int i = N; i >= 1; i--) {
            if (array[i] != i) {
                int s = 1;
                int e = i;
                for (int j = 1; j < e; j++) {
                    if (array[j] == i) {
                        s = j;
                        break;  
                    }
                }
                reverse(s, e);
                reverseCnt++;

                if (reverseCnt == 1) {
                    first.x = s; 
                    first.y = e;
                } else if (reverseCnt == 2) {
                    second.x = s;
                    second.y = e;
                }
            }
            if (reverseCnt >= 3) {
                break;
            }
        }
        return reverseCnt <= 2;
    }

    private static void reverse(int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++; 
            end--;
        }
    }
}
 
class Interval {
    int x, y;

    public Interval() {
        x = 1;
        y = 1;
    }

    public void reset() {
        x = 1;
        y = 1;
    }
}
