import java.util.Scanner;

public class N1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		sc.close();
		
		int[] count = new int[26];
		int max = 0;
		char output = 0;

		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'A']++; // str의 i번째 문자의 횟수를 arr[]에 ++

			if (max < count[str.charAt(i) - 'A']) {
				max = count[str.charAt(i) - 'A'];
				output = str.charAt(i);
				
			} else if (max == count[str.charAt(i) - 'A']) {
				output = '?';
			}
		}		
		System.out.println(output);
		
	}
}
