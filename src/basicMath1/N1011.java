package basicMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1011 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] strArr = br.readLine().split(" ");
			int x = Integer.parseInt(strArr[0]);
			int y = Integer.parseInt(strArr[1]);

			int distance = y - x;

			int max = (int) Math.sqrt(distance);

			if (max == Math.sqrt(distance)) {
				System.out.println(max * 2 - 1);
			} else if (distance <= max * max + max) {
				System.out.println(max * 2);
			} else {
				System.out.println(max * 2 + 1);
			}

		}
	}
}
