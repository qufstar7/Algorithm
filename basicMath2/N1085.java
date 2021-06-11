package basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1085 { // 직사각형에서 탈출

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x, y, w, h;
		// 입력한 x, y, w, h를 str배열을 이용해 저장
		String[] str = br.readLine().split(" "); 
		x = Integer.parseInt(str[0]);
		y = Integer.parseInt(str[1]);
		w = Integer.parseInt(str[2]);
		h = Integer.parseInt(str[3]);

		// arr배열에 x축, y축의 거리 4개 저장
		int arr[] = new int[4];
		arr[0] = w - x;
		arr[1] = h - y;
		arr[2] = y - 0;
		arr[3] = x - 0;

		// 4개의 거리를 비교해 최솟값 산출
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}

		System.out.println(min);

	}

}
