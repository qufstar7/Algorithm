package basicMath2;

import java.io.*;
import java.util.ArrayList;

public class N9020 { // 골드바흐의 추측

	static int range = 10000;
	static ArrayList<Boolean> primeList = new ArrayList<Boolean>(range + 1);

	// T(테스트케이스 개수), n(테스트케이스)입력
	public static void main(String[] args) throws IOException {
		primeNumber(range);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n = 0;
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			System.out.println(goldBachPartition(n));
		}

	}

	// 골드바흐 파티션 구하기
	public static StringBuffer goldBachPartition(int num) {
		StringBuffer sb = new StringBuffer();

		for (int i = num / 2; i >= 2; i--) {
			if (primeList.get(i) && primeList.get(num - i)) {
				sb.append(i).append(" ").append(num - i);
				break;
			}
		}
		return sb;

	}

	// 소수 구하기
	public static void primeNumber(int range) {
		primeList.add(false);
		primeList.add(false);
		for (int i = 2; i <= range; i++)
			primeList.add(i, true);
		for (int i = 2; (i * i) <= range; i++) {
			if (primeList.get(i)) {
				for (int j = i * i; j <= range; j += i)
					primeList.set(j, false);
			}
		}
	}
}
