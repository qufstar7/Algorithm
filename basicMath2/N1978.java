package basicMath2;

import java.util.ArrayList;
import java.util.Scanner;

public class N1978 {

	public static void main(String[] args) {

		// 입력
		Scanner scan = new Scanner(System.in);
		// 범위, (1000이하의 자연수)
		int n = 1000;
		int N = scan.nextInt();
		int count = 0;
		StringBuffer sb = new StringBuffer();
		for (int a = 0; a < N; a++) {
			int num = scan.nextInt();
			// ArrayList로 구현
			ArrayList<Boolean> primeList;
			// n+1만큼 할당
			primeList = new ArrayList<Boolean>(n + 1);
			// 0번째와 1번째를 소수 아님으로 처리
			primeList.add(false);
			primeList.add(false);
			// 2 ~ n 까지 소수로 설정
			for (int i = 2; i <= n; i++)
				primeList.add(i, true);
			// 2 부터 ~ i*i <= n
			// 각각의 배수들을 지워간다.
			for (int i = 2; (i * i) <= n; i++) {
				if (primeList.get(i)) { // 중복처리 배제
					for (int j = i * i; j <= n; j += i)
						primeList.set(j, false);
					// i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
				}
			}
			// count에 소수의 갯수 저장
			if (primeList.get(num) == true) {
				count++;
			}
		}
		scan.close();
		// 출력
		sb.append(count);
		System.out.println(sb);

	}

}
