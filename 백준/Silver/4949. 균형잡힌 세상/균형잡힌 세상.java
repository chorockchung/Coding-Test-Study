import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        while(!s.equals(".")) {
            Deque<Character> deque = new ArrayDeque<>();
            boolean isBalanced = true;

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '(' || c == '[') {
                    deque.add(c);
                } else if(c == ')') {
                    if(deque.isEmpty() || deque.peekLast() != '(') {
                        isBalanced = false;
                        break;
                    } else {
                        deque.pollLast();
                    }
                } else if(c == ']') {
                    if(deque.isEmpty() || deque.peekLast() != '[') {
                        isBalanced = false;
                        break;
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if(isBalanced && deque.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }

            s = br.readLine();
        }

        System.out.print(sb);
    }
}
