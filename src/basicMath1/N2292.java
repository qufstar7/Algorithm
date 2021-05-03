package basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// A = group begin number (지나 가는 방의 갯수가 증가하는 방)
		int A = 2;
		int count = 1;
		for (int i = 1; i <= N; i++) {
			if (A > N) {
				break;
			}
			A += 6 * i;	
			count++;
		}
		System.out.println(count);
		
	}
}