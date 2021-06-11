package basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11653 { // 소인수분해

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		StringBuffer sb = new StringBuffer();

		int temp = N;
		// 2부터 N까지 검사
		for (int i = 2; i <= N; i++) {
			// i가 temp의 소인수면 i로 나누고 append
			while (temp % i == 0) {				
				temp = temp / i;
				sb.append(i + "\n");
			}
			// temp가 1이 되면 break
			if (temp == 1)
				break;
		}

		System.out.println(sb);

	}
}
