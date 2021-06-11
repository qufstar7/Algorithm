package basicMath2;

import java.util.ArrayList;
import java.util.Scanner;

public class N2581 { // 소수
	// (에라토스테네스의 체 방식 사용)
	public static void main(String[] args) {

		// 입력
		Scanner scan = new Scanner(System.in);
		// M, N 입력받음
		int M = scan.nextInt();
		int N = scan.nextInt();
		scan.close();
		// 블리언 ArrayList로 구현
		ArrayList<Boolean> primeList;
		// N + 1 만큼 할당 (0 ~ N)
		primeList = new ArrayList<Boolean>(N);
		// 0, 1은 소수아님 처리
		primeList.add(0, false);
		primeList.add(1, false);
		// 2 ~ N까지 소수 처리
		for (int i = 2; i <= N; i++)
			primeList.add(i, true);
		// 2 부터 ~ i*i <= N
		// 각각의 배수들 false 처리
		for (int i = 2; (i * i) <= N; i++) {
			if (primeList.get(i) == true) { // 중복처리 배제
				for (int j = i * i; j <= N; j += i)
					primeList.set(j, false);
				// i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
			}
		}

		// 합, 최솟값
		int sum = 0;
		int min = 0;
		// sum
		for (int i = M; i <= N; i++) {
			if (primeList.get(i) == true) {
				sum += i;
			}
		}
		// min
		for (int i = M; i <= N; i++) {
			if (primeList.get(i) == true) {
				min = i;
				break;
			}
		}
		// 0 ~ M-1 소수아님처리
		for (int i = 0; i < M; i++) {
			primeList.set(i, null);
		}

		// 데이터 저장
		StringBuffer sb = new StringBuffer();
		// 출력
		if (primeList.contains(true)) {
			sb.append(sum + "\n" + min);
		} else {
			sb.append("-1");
		}
		System.out.println(sb.toString());

	}

}
