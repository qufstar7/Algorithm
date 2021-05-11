package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10872 { // 팩토리얼

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// for문 사용
//		int Nfac = 1;
//		for (int i = 2; i <= N; i++) {
//			Nfac *= i;
//		}
//		System.out.println(Nfac);

		System.out.println(factorial(N));
		
	}

	// 재귀 호출 사용
	public static int factorial(int N) {
		if (N == 0) {
			return 1;
		} else {
			return N * factorial(N - 1);
		}

	}

}
