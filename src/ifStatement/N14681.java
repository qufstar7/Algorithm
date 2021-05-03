package ifStatement;

import java.util.Scanner;

public class N14681 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println((x>0)? (y>0)? "1":"4":(y>0)? "2":"3");
	}
}