package forStatement;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class N10871 {

	public static void main(String[] args) throws NumberFormatException, IOException {

//		1. 배열	
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int X = sc.nextInt();
//		int[] A = new int[N];
//		for (int i = 0; i < N; i++) {
//			A[i] = sc.nextInt();				
//		}				
//		sc.close();		
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] < X) {
//				System.out.print(A[i]+" ");
//			}
//		}

//		2. 배열 x 
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int X = sc.nextInt();					
//		StringBuilder sb = new StringBuilder();		
//		for (int i = 0; i < N; i++) {
//			int A = sc.nextInt();
//			if (A < X) {
//				sb.append(A+" ");
//			}			
//		}
//		System.out.println(sb);

//		3. 고성능	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 수열의 개수
		int X = Integer.parseInt(st.nextToken()); // 수열에서 x 보다 작은 수 출력
		
		StringBuilder sb = new StringBuilder();		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int A = Integer.parseInt(st.nextToken());
			if (A < X) 
				sb.append(A).append(' ');			
		}
		System.out.println(sb);

	}

}
