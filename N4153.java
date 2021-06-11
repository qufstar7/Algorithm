package basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4153 { // 직각삼각형

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] str = br.readLine().split(" ");
			// 세변의 길이 x, y, z
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int z = Integer.parseInt(str[2]);
			// 0이 입력되면 종료
			if (x == 0) {
				break;
			}
			// 정렬
			int temp = 0;
			if (y > x && y > z) {
				temp = y;
				y = x;
				x = temp;
			} else if (z > x && z > y) {
				temp = z;
				z = x;
				x = temp;
			}
			// 직각삼각형 구분
			if (x * x == y * y + z * z) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}
		System.out.println(sb);
	}
}
