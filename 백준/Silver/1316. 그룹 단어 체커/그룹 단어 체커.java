import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();

        int groupWordCount = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            boolean isGroupWord = true;
            boolean[] visited = new boolean[26];

            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                int index = currentChar - 'a';

                if (visited[index]) {
                    if (word.charAt(j - 1) != currentChar) {
                        isGroupWord = false;
                        break;
                    }
                } else {
                    visited[index] = true;
                }
            }

            if (isGroupWord) {
                groupWordCount++;
            }
        }

        System.out.println(groupWordCount);
    }
}
