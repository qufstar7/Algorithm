package bruteForce;

import java.io.*;

public class N2798 { // 블랙잭

	static int M; // 기준
	static int r = 3; // 3장의 카드
	static int[] card; // 카드 배열(N개)
	static int[] comb; // 조합
	static int sum; // 조합의 합
	static int ans; // 답 (M보다 작거나 같은 가장 큰 합)

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		String[] str = br.readLine().split(" "); 
		int N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);		
		String[] str2 = br.readLine().split(" ");
		card = new int[N]; // N개의 카드 배열
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(str2[i]);
		}
		
		// 계산 및 출력
		comb = new int[r];		
		nCr(0, 0);
		System.out.println(ans);
	}

	public static void nCr(int combIndex, int cardIndex) { // 조합

		if (combIndex == r) { // 0 ~ 3 
			for (int i = 0; i < r; i++) { // 조합의 합
				sum += comb[i];
			}
			if (sum <= M && sum > ans) { // M보다 작거나 같은 가장 큰 합
				ans = sum;
			}
			sum = 0;
			return;
		}
		// 무차별 대입
		for (int i = cardIndex; i < card.length; i++) {
			comb[combIndex] = card[i];
			nCr(combIndex + 1, i + 1);
		}

	}

}