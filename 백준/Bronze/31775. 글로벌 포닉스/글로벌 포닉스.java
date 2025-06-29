import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            if (!s.isEmpty()) {
                set.add(s.charAt(0));
            }
        }
        if (set.contains('l') && set.contains('k') && set.contains('p')) {
            System.out.println("GLOBAL");
        } else {
            System.out.println("PONIX");
        }
    }
}
