import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int cnt0 = 0, cnt1 = 0;
		char before = ' ';
		for(char c : str.toCharArray()) {
			if(before == '1' && c == '0') {
				cnt0++;
			}
			if(before == '0' && c == '1') {
				cnt1++;
			}
			before = c;		
		}
		
		if(str.startsWith("1")) cnt1++;
		else cnt0++;

		System.out.print(Math.min(cnt1, cnt0));
	}
}