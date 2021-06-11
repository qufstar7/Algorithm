package recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N2447 { // 별 찍기 - 10

	static char[][] arr; // 2차원 배열

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N]; // N*N 행렬의 2차원 배열
		// 함수 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], ' ');
		}
		// 함수 실행
		starPattern(0, 0, N);
		// 출력
		for (int i = 0; i < N; i++) {
			bw.write(arr[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	public static void starPattern(int x, int y, int size) {
		// 역순으로 프로그램이 *을 채워 넣고 종료
		if (size == 1) {
			arr[x][y] = '*';
			return;
		}
		// 재귀 함수
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i * j == 1) // [1,1]은 공백
					continue; // 건너뜀
				starPattern(x * 3 + i, y * 3 + j, size / 3);
			}
		}
	}
}