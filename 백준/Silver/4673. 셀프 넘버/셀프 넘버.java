import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[10001];
        
        for(int i = 1; i <= 10000; i++) {
            int sum = i;
            for(char c : Integer.toString(i).toCharArray()) {
                sum += c - '0';
            }
            if (sum <= 10000) {
                arr[sum] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= 10000; i++) {
            if(!arr[i])
                sb.append(i).append('\n');
        }
        
        System.out.println(sb);
    }
}
