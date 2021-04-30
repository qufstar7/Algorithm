package basicMath1;

import java.io.*;

public class N2839 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1 || N == 2 || N == 4 || N == 7) { // 1,2,4,7 은 -1 출력
			System.out.println("-1");
		} else {
			if (N % 5 == 0) { // 5로 나눠 떨어지면
				System.out.println(N / 5);

			} else { // 5로 나눠 떨어지지 않을 때
				if (N % 5 == 1) { // 5로 나눈 나머지가 1이면
					System.out.println( (N-6)/5 + 2 );				
				}
				if (N % 5 == 2) { // 5로 나눈 나머지가 2이면
					System.out.println( (N-12)/5 + 4);
				}
				if (N % 5 == 3) { // 5로 나눈 나머지가 3이면
					System.out.println( N / 5 + 1 );
				}
				if (N % 5 == 4) { // 5로 나눈 나머지가 4이면
					System.out.println( (N-9)/5 + 3 );
				}

			}
		}	
		
	}
}