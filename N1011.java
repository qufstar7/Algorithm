package basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class N1011 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] strArr = br.readLine().split(" ");
			int x = Integer.parseInt(strArr[0]);
			int y = Integer.parseInt(strArr[1]);

			int k = y - x; // k : 이동거리
			int ans = 0; // ans : 장치 작동 횟수 (답)
			int cnt = 0; // 카운트

			for (int j = 1; ans < k; j++) {
				ans += i;
				cnt++;
				if (ans >= k) {
					break;
				}
				ans += i;
				cnt++;
			}
			System.out.println(cnt);
		}

	}
}
