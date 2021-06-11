
import java.io.IOException;

import java.util.Scanner;

public class N4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); // 테스트 케이스 입력
		
		int[] arr;
	
		for (int i = 0; i < C; i++) {
			int N = sc.nextInt(); // 학생 수 N명
			arr = new int[N];
			
			double sum = 0;
			
			for (int j = 0; j < N; j++) {
				int score = sc.nextInt(); // 성적 입력
				arr[j] = score;
				sum += arr[j];
			}
			
			double avg = (sum/N);
			double count = 0;
			
			for (int j = 0; j < N; j++) {
				if (arr[j] > avg) {
					count++;
				}
			}			
			System.out.printf("%.3f%%\n",(count/N)*100);
		}		
		
		
	}

}
