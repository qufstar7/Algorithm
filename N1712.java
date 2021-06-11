import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1712 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int C = Integer.parseInt(input[2]);

		// 첫 번째 풀이법
//		if (B >= C) {
//			System.out.println("-1");
//		} else {
//			System.out.println(A/(C-B)+1);
//		}

		// 두 번째 풀이법
//		int N = 1;
//		if (B >= C) {
//			System.out.println("-1");
//		}
//		while (true) {
//			if ((C * N) > (A + B * N)) {
//				break;
//			}
//			N++;
//		}
//		System.out.println(N);

		// 세 번째 풀이법 (왜 틀렸습니다?)
//		int N = 1;
//		if (B >= C) {
//			System.out.println("-1");
//		} else {
//			for (N = 1; N < 2100000001; N++) {
//				if ((C * N) > (A + B * N)) {
//					System.out.println(N);
//					break;
//				}
//			}
//		}
		
	}
}
