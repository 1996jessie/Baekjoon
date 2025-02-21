import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        int watermelon = Integer.parseInt(br.readLine());
        int pomegranates = Integer.parseInt(br.readLine());
        int nuts = Integer.parseInt(br.readLine());

        if (b >= watermelon) {
            System.out.println("Watermelon");
        } else if (b >= pomegranates) {
            System.out.println("Pomegranates");
        } else if (b >= nuts) {
            System.out.println("Nuts");
        } else {
            System.out.println("Nothing");
        }
    }
}
