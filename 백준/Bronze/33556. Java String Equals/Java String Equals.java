import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        
        A = A.equals("null") ? null : A;
        B = B.equals("null") ? null : B;

        try {
            System.out.println(A.equals(B));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

        try {
            System.out.println(A.equalsIgnoreCase(B));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }
}
