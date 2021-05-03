package whileStatement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10952 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();

		while (A != 0 && B != 0) {
			st = new StringTokenizer(br.readLine()," ");
			sb.append(A + B+"\n");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());			
		}
		System.out.println(sb);
	}

}
