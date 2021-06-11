package basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3009 { // 네 번째 점

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");
		String[] secondLine = br.readLine().split(" ");
		String[] thirdLine = br.readLine().split(" ");
		//dot1x~dot4y까지 4점의 좌표를 선언
		int dot1x = Integer.parseInt(firstLine[0]);
		int dot1y = Integer.parseInt(firstLine[1]);
		int dot2x = Integer.parseInt(secondLine[0]);
		int dot2y = Integer.parseInt(secondLine[1]);
		int dot3x = Integer.parseInt(thirdLine[0]);
		int dot3y = Integer.parseInt(thirdLine[1]);
		int dot4x = 0;
		int dot4y = 0;

		// dot1y와 dot2y가 같으면 dot3y가 dot4같음 경우의 수 3(반복)
		if (dot1y == dot2y) {
			dot4y = dot3y;
			//dot4x좌표 경우의 수 3(반복)
			if (dot1x == dot2x) {
				dot4x = dot3x;
			} else if (dot1x == dot3x) {
				dot4x = dot2x;
			} else {
				dot4x = dot1x;
			}
		} else if (dot1y == dot3y) {
			dot4y = dot2y;
			if (dot1x == dot2x) {
				dot4x = dot3x;
			} else if (dot1x == dot3x) {
				dot4x = dot2x;
			} else {
				dot4x = dot1x;
			}
		} else if (dot2y == dot3y) {
			dot4y = dot1y;
			if (dot1x == dot2x) {
				dot4x = dot3x;
			} else if (dot1x == dot3x) {
				dot4x = dot2x;
			} else {
				dot4x = dot1x;
			}
		}
		System.out.println(dot4x+" "+dot4y);
		
	}

}
