package basicMath1;

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

		// ù ��° Ǯ�̹�
		if (B >= C) {
			System.out.println("-1");
		} else {
			System.out.println(A/(C-B)+1);
		}

		// �� ��° Ǯ�̹�
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

		// �� ��° Ǯ�̹� (��? Ʋ�Ƚ��ϴ�? �Ƹ��� ū �� 2100000001�� ����ؼ� integer ȣȯ����)
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
