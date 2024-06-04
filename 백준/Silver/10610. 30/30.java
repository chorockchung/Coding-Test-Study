import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = 0;
		char[] input = br.readLine().toCharArray();
		for(char ch : input) {
			int n = ch - 48;
			total += n;
		}
		
		List<Character> list = new ArrayList<>();
		for(char ch : input) {
			list.add(ch);
		}
		Collections.sort(list, (c1, c2) -> Character.compare(c2, c1));
		
		if(list.get(list.size()-1) != '0' || total % 3 != 0)
			System.out.println("-1");
		else {
			for(char ch : list) {
				System.out.print(ch);
			}
		}
			
		br.close();
	}
}
