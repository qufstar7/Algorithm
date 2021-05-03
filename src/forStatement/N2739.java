package forStatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class N2739 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bReader.readLine());

		for (int i = 1; i < 10; i++) {
			System.out.println(N + " * " + i + " = " + N * i);
		}

	}
}

//for (int i = 1; i < 10; i++) {
//	System.out.println(N * i);
//}
//}