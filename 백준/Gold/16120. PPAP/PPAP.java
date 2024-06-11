import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
        
        if(sb.toString().equals("P") || sb.toString().equals("PPAP")) {
			System.out.println("PPAP");
			return;
		}
        
		StringBuilder stack = new StringBuilder();

		int stackSize = 0;
		for(int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			stack.append(ch);		
			++stackSize;
			if(stackSize >= 4 && stack.substring(stackSize - 4, stackSize).equals("PPAP")) {
				if(i == sb.length() - 1)
					break;
				stack.delete(stackSize-3, stackSize); //pap만 삭제
				stackSize -= 3;
			}
		}	
		
		if(stackSize != 4)
			System.out.println("NP");
		else if(!stack.toString().equals("PPAP"))	
			System.out.println("NP");
		else  
			System.out.println("PPAP");
	}
}
