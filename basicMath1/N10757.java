package basicMath1;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

public class N10757 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
//		String[] strArr = br.readLine().split(" ");		
//		BigInteger A = new BigInteger(strArr[0]);
//		BigInteger B = new BigInteger(strArr[1]);	

		BigInteger sum = A.add(B);
		System.out.println(sum);

	}

}
