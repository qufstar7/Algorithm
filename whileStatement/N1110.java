import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Scanner;

public class N1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		int copy = N; // 변수 복사
		int count = 0;

		// 배열 없이
//		A = (N%10)*10 // N의 일의 자리 수는 A의 십의 자리 수
//		A = (N/10 + N%10)%10 // N의 각 자리 수 합의 일의 자리 수는 A의 일의 자리수 		
//		A = (N%10)*10 + (N/10 + N%10)%10				
//		
//		// 배열 없이 1번 : count 하나 씩 추가하며 N 재정의하다 copy가 N과 같아 지면 break;
//		while (true) {
//			N = ((N%10)*10 + (N/10 + N%10)%10);
//			count++;
//			
//			if(copy == N) {
//				break;
//			}
//		}		
//		System.out.println(count);
//			
//		// 배열 없이 2번 : count 세며 N 재정의 copy가 N과 같지 않을 동안 반복
//		do {
//			N = ((N%10)*10 + (N/10 + N%10)%10);
//			count++;
//		} while(copy != N);
//		
//		System.out.println(count);
//		
//		
//				
//	    // 배열로
//		A[0] = N[1] // N의 일의 자리 수는 A의 십의 자리 수
//		A[1] = N[0]+N[1] // N의 십의 자리 수는 A의 십의 자리 수와 일의 자리 수의 합
		ArrayList<Integer> data = new ArrayList<Integer>(2);
		if (N < 10) {
			data.add(0);
			data.add(N);
		} else {
			data.add(N / 10);
			data.add(N % 10);
		}
		
		while (true) {
			count++;
			int i3 = data.get(0) + data.get(1);
			i3 = i3 % 10;
			data.set(0, data.get(1));
			data.set(1, i3);
			if (N / 10 == data.get(0) && N % 10 == data.get(1))
				break;

		}

		System.out.println(count);

	}
}
