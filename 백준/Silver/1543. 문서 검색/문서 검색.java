import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        int count = 0;
        int index = 0;
        while (index <= doc.length() - word.length()) {
            if (doc.substring(index, index + word.length()).equals(word)) {
                count++;
                index += word.length();
            } else {
                index++;
            }
        }
        System.out.println(count);
    }
}
