import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        boolean odd = true, even = true;
        for(int f : freq) {
            if(f > 0) {
                if(f % 2 == 0) {
                    odd = false;
                } else {
                    even = false;
                }
            }
        }
        if(odd) {
            System.out.println(1);
        } else if(even) {
            System.out.println(0);
        } else {
            System.out.println("0/1");
        }
    }
}
