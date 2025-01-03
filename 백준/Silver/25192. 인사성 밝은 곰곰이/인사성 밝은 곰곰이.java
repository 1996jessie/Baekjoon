import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int count = 0;
        HashSet<String> hs = new HashSet<>();

        for(int i=0;i<n;i++){
            String str = br.readLine();

            if(str.equals("ENTER")){
                hs.clear();
                continue;
            } else if(!hs.contains(str)){
                hs.add(str);
                count++;
            }
        }
        br.close();
        System.out.print(count);
    }
}