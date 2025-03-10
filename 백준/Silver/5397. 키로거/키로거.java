import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            String input = br.readLine();
            LinkedList<Character> password = new LinkedList<>();
            ListIterator<Character> cursor = password.listIterator();
            
            for (char ch : input.toCharArray()) {
                if (ch == '-') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else if (ch == '<') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                } else if (ch == '>') {
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                } else {
                    cursor.add(ch);
                }
            }
            
            for (char ch : password) {
                output.append(ch);
            }
            output.append('\n');
        }
        
        System.out.print(output);
    }
}
