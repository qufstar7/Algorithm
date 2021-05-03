package basicMath1;

import java.io.*;
import java.util.StringTokenizer;

public class N10250 { // ACM 호텔

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); // 테스트 데이터 개수
		int H = 0;
		int W = 0;
		int N = 0;
		for (int i = 0; i < T; i++) { // (1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W)
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 호텔의 층 수
			W = Integer.parseInt(st.nextToken()); // 각 층의 방 수
			N = Integer.parseInt(st.nextToken()); // 손님 순서

			if (N % H != 0) {
				bw.write(String.valueOf((N % H * 100) + (N / H + 1)));
			} else {
				bw.write(String.valueOf((H * 100) + (N / H)));
			}
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();

		// 숏코딩
//		import java.util.*;
//
//		public class test {
//			public static void main(String[] args) {
//				Scanner sc = new Scanner(System.in);
//				int T = sc.nextInt();
//				for (int i = 0; i < T; i++) {
//					int H = sc.nextInt();
//					int W = sc.nextInt();
//					int N = sc.nextInt();
//					System.out.println(((N - 1) % H + 1) * 100 + ((N - 1) / H + 1);
//				}
//			}
//		}
		
	}

}
