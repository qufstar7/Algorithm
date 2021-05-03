package basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class N2869 {

	public static void main(String[] args) throws IOException {
		
		// #1 반복문, br
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int A, B, V;
//		String[] input = br.readLine().split(" ");
//		A = Integer.parseInt(input[0]);
//		B = Integer.parseInt(input[1]);
//		V = Integer.parseInt(input[2]);
//		int days = 0;
//		int location = 0;
//		StringBuilder sb = new StringBuilder();
//		while( true ) {
//			days += 1;
//			location += A; 
//			if(location >= V) {				
//				break;
//			} else
//				location -= B;			
//		}
//		sb.append(days);
//		System.out.println(sb);
		
		// #2 조건문
//		if ((V - A) % (A - B) == 0) {
//		if ((V - A) >= (A - B)) { 			// 틀렸습니다.
//			days = (V - A) / (A - B) + 1;
//		} else {
//			days = (V - A) / (A - B) + 2;
//		}
//		System.out.println(days);
		
		// #3 삼항연산자, bw, br, st, io* 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int days = 1 + ((V - A) % (A - B) == 0 ? (V - A) / (A - B) : (V - A) / (A - B) + 1);
		bw.write(days+"\n");
		bw.flush();
		br.close();
		bw.close();

	}

}
