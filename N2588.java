package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2588 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int A = Integer.parseInt(br.readLine());
			String B = br.readLine();
			int num_B = Integer.parseInt(B);
			
			System.out.println(A * Integer.parseInt(B.substring(2)));
			System.out.println(A * Integer.parseInt(B.substring(1, 2)));
			System.out.println(A * Integer.parseInt(B.substring(0, 1)));
			System.out.println(A * num_B);
			
		} catch (IOException e) {
			System.out.println("io err");
			e.printStackTrace(); // 모든 추가 오류
			e.getMessage(); // 오류 종류
		}
	}
}
