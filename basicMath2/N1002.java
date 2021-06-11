package basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1002 { // 터렛

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		// T번 입력, 계산, 저장
		for (int i = 0; i < T; i++) {
			String[] strArr = br.readLine().split(" ");
			// 입력데이터 변수에 저장
			int x1 = Integer.parseInt(strArr[0]);
			int y1 = Integer.parseInt(strArr[1]);
			int r1 = Integer.parseInt(strArr[2]);
			int x2 = Integer.parseInt(strArr[3]);
			int y2 = Integer.parseInt(strArr[4]);
			int r2 = Integer.parseInt(strArr[5]);

			int R = 0; // 큰 반지름
			int r = 0; // 작은 반지름
			double d = 0; // 중심 사이의 거리

			// r2, r1 크기 비교
			if (r2 >= r1) {
				R = r2;
				r = r1;
			} else {
				R = r1;
				r = r2;
			}
			// 중심 사이의 거리
			d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

			// 위치의 개수가
			// 무한대
			if (d == 0 && R == r) {
				sb.append(-1).append("\n");
			}
			// 0개
			else if (d > R + r || d < R - r || d == 0 && R != r) {
				sb.append(0).append("\n");
			}
			// 한 개
			else if (d == R + r || d == R - r) {
				sb.append(1).append("\n");
			}
			// 두 개
			else if (d < R + r && d > R - r) {
				sb.append(2).append("\n");
			}

		}
		// 출력
		System.out.println(sb);
	}

}
