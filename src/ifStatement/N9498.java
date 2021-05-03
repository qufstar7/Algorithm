package ifStatement;

import java.util.Scanner;

public class N9498 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		
//		System.out.println(89<T?"A":79<T?"B":69<T?"C":59<T?"D":"F");
		System.out.println(60>T?"F":70>T?"D":80>T?"C":90>T?"B":"A");
		
	}

}
