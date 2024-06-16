import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String t = br.readLine();
        
        while (t.length() > s.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                // Remove the last 'A'
                t = t.substring(0, t.length() - 1);
            } else if (t.charAt(t.length() - 1) == 'B') {
                // Remove the last 'B' and reverse the string
                t = new StringBuilder(t.substring(0, t.length() - 1)).reverse().toString();
            }
        }
        
        // Check if t has been reduced to s
        if (t.equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
