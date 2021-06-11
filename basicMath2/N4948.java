package basicMath2;

import java.io.*;

public class N4948 { // 베르트랑 공준

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		// 123456*2+1
		boolean[] primeList = new boolean[246913];
		// 0번째와 1번째를 소수 아님으로 처리
		primeList[0] = primeList[1] = true;
		// 2 부터 ~ i*i <= primeList.size()
		// 각각의 배수들을 지워간다.
		for (int i = 2; (i * i) <= primeList.length; i++) {
			if (primeList[i])
				continue;
			for (int j = i * i; j <= primeList.length; j += i)
				primeList[j] = true;
			// i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
		}

		// n입력 받고 count 저장
		int n = 1;
		while (n != 0) {
			n = Integer.parseInt(br.readLine());
			// n = 0 이면 종료
			if (n == 0) {
				break;
			}
			// count
			int count = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (!primeList[i]) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		// 출력
		br.close();
		System.out.println(sb);
	}

}
