package forStatement;

import java.util.Scanner;

public class N10950 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		scanner.close();

		int T = scanner.nextInt();

		for (int i = 1; i < T + 1; i++) {
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			System.out.println(A + B);
		}

	}
}
