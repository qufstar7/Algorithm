package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11729 { // 하노이 탑 이동 순서

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = (int) (Math.pow(2, n) - 1); // 옳긴 횟수
		sb.append(k + "\n");
		TowerOfHanoi(n, 1, 2, 3); // N개의 원판, 장대 이름은 각각 1, 2, 3
		System.out.println(sb);
	}

	// 하노이의 탑 - N개의 원판을 A번쨰 탑과 B번째 탑으로 옳기는 과정 계산, 출력 함수
	public static void TowerOfHanoi(int n, int start, int mid, int end) {
		// 스택 참조 및 반복문 종료
		if (n == 1) {
			sb.append(start + " " + end + "\n");
		} else {
			TowerOfHanoi(n - 1, start, end, mid); // 2, 3 호환
			sb.append(start + " " + end + "\n"); // 1 3 고정(상수)
			TowerOfHanoi(n - 1, mid, start, end); // 1, 2 호환
		}
	}

}