package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10870 { // 피보나치 수 5

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacci(n));
		
		// 배열, for문 사용
//		int[] fSeqArr = new int[21]; // 0<=n<=20
//		fSeqArr[0] = 0;
//		fSeqArr[1] = 1;
//
//		for (int i = 2; i <= n; i++) {
//			fSeqArr[i] = fSeqArr[i - 2] + fSeqArr[i - 1];
//		}https://github.com/qufstar7/Algorithm/upload/main
//		System.out.println(fSeqArr[n]);		
		
	}
	
	// 재귀 사용
	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}

	}

}
