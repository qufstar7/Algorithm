package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2231 { // 분해합
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int N = Integer.parseInt(str);
		System.out.println(len);
		System.out.println(N-(len * 9));
		System.out.println(N-((len-1) * 9));
		int ans = 0;
		for (int i = (N - ((len * 9))); i < N; i++) {
			int number = i;
			int sum = 0;
			while (number != 0) {
				sum += number % 10;
				number /= 10;
			}
			if (sum + i == N) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}