import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2675 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//scanner 사용
//		Scanner sc = new Scanner(System.in);
//		
//		int T = sc.nextInt();
//
//		for (int i = 0; i < T; i++) {
//			
//			int R = sc.nextInt();
//			String S = sc.next();
//			
//			for (int j = 0; j < S.length(); j++) {
//				for (int k = 0; k < R; k++) {
//					System.out.print(S.charAt(j));
//				}
//			}
//			System.out.println();
//		}

		// bufferReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			String[] str = br.readLine().split(" ");
			int R = Integer.parseInt(str[0]);
			String S = str[1];

			for (int j = 0; j < S.length(); j++) {
				for (int k = 0; k < R; k++) {
					System.out.print(S.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
