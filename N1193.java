package basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int[] mol = new int[X+1]; // 분자 molecular
		int[] den = new int[X+1]; // 분모 denominator
		int maxOdd = 1; // maxOdd에 홀수 최고값 저장
		int maxEven = 0; // maxEven에 짝수 최고값 저장
	

		// X번째 분수 찾기
		for (int i = 1; i <= X-1; i++) {

			// X번째 분자 찾기
			mol[0] = 1;
			mol[1] = 1;
			if (mol[i] == 1) {
				if (mol[i - 1] == 1) {
					mol[i + 1] = 2;
				} else {
					mol[i + 1] = 1;
				}
			} else {
				// 홀수일 때
				if (mol[i] % 2 != 0 && mol[i] > maxOdd) {
					maxOdd = mol[i];
					mol[i + 1] = mol[i] - 1;
				} else if (mol[i] % 2 != 0 && mol[i] <= maxOdd) {
					if (mol[i] > mol[i - 1]) {
						mol[i + 1] = mol[i] + 1;
					} else {
						mol[i + 1] = mol[i] - 1;
					}
					// 짝수일 때
				} else if (mol[i] % 2 == 0 && mol[i] > mol[i - 1]) {
					mol[i + 1] = mol[i] + 1;
				} else if (mol[i] % 2 == 0 && mol[i] < mol[i - 1]) {
					mol[i + 1] = mol[i] - 1;
				}
			}			

			// X번째 분모 찾기
			den[0] = 1;
			den[1] = 2;
			if (den[i] == 1) {
				if (den[i - 1] == 1) {
					den[i + 1] = 2;
				} else {
					den[i + 1] = 1;
				}
			} else {
				// 짝수일 때
				if (den[i] % 2 == 0 && den[i] > maxEven) {
					maxEven = den[i];
					den[i + 1] = den[i] - 1;
				} else if (den[i] % 2 == 0 && den[i] <= maxEven) {
					if (den[i] > den[i - 1]) {
						den[i + 1] = den[i] + 1;
					} else {
						den[i + 1] = den[i] - 1;
					}
					// 홀수일 때
				} else if (den[i] % 2 != 0 && den[i] > den[i - 1]) {
					den[i + 1] = den[i] + 1;
				} else if (den[i] % 2 != 0 && den[i] < den[i - 1]) {
					den[i + 1] = den[i] - 1;
				}
			}

		}
		System.out.println(mol[X-1] + "/" + den[X-1]);
	}

}
