import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();
        
        if (isValidWord(word)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isValidWord(String word) {
        int i = 0;
        int n = word.length();
        
        while (i < n) {
            if (word.charAt(i) != 'w') {
                return false;
            }
            int count_w = 0;
            while (i < n && word.charAt(i) == 'w') {
                count_w++;
                i++;
            }
            
            if (i < n && word.charAt(i) != 'o') {
                return false;
            }
            int count_o = 0;
            while (i < n && word.charAt(i) == 'o') {
                count_o++;
                i++;
            }
            
            if (i < n && word.charAt(i) != 'l') {
                return false;
            }
            int count_l = 0;
            while (i < n && word.charAt(i) == 'l') {
                count_l++;
                i++;
            }
            
            if (i < n && word.charAt(i) != 'f') {
                return false;
            }
            int count_f = 0;
            while (i < n && word.charAt(i) == 'f') {
                count_f++;
                i++;
            }
            
            if (count_w != count_o || count_o != count_l || count_l != count_f) {
                return false;
            }
        }
        return true;
    }
}
