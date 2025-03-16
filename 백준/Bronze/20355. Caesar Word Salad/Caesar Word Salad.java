import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String w = sc.nextLine();
        int count = 0;

        for (int shift = 0; shift < 26; shift++) {
            if (isIFreeShift(w, shift)) {
                count++;
            }
        }

        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("impossible");
        }
    }

    static boolean isIFreeShift(String w, int shift) {
        for (char c : w.toCharArray()) {
            char shiftedChar = (char) ('a' + (c - 'a' + shift) % 26);
            if (shiftedChar == 'i') {
                return false;
            }
        }
        return true;
    }
}
