import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String line = sc.nextLine();
            
            if (line.equals("*")) {
                break;
            }
            
            String[] words = line.split(" ");
            char firstChar = Character.toLowerCase(words[0].charAt(0));
            boolean isTautogram = true;
            
            for (String word : words) {
                if (Character.toLowerCase(word.charAt(0)) != firstChar) {
                    isTautogram = false;
                    break;
                }
            }
            
            if (isTautogram) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
        
        sc.close();
    }
}
