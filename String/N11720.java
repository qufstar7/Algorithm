import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String numbers = br.readLine();
		int[] numbersArr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			numbersArr[i] = Integer.parseInt(numbers.charAt(i)+"");
			sum += numbersArr[i];
		}		
		System.out.println(sum);
	}
}


// ### fast-program
// ### toCharArray�� ����Ͽ� char�迭�� ���� ���ڸ���Ʈ�� �ް� Character.getNumericValue()�� ���ڵ��� ���� �־���. for (A :B){} �� B���� ���ʴ�� ��ü�� ������ A���ٰ� �ִ� �ݺ���. 

//import java.io.*;
//public class N11720 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numChar = Integer.parseInt(br.readLine());
//        char[] line = br.readLine().toCharArray();
//        int sum = 0;
//        for (char c : line) {
//            int num = Character.getNumericValue(c);
//            sum += num;
//        }
//        System.out.println(sum);
//    }
//}


// ## short-coding 
// ### �Ľ� ��� (int) s.charAt(i) - '0'; (�Ǵ� string.charAt(i) - 48;) ���� ���ڿ��� ����Ÿ������ �ٲ� �� �ִ�. (�Ľ��� ��õ��)

//import java.util.*;
//public class N11720 {
//	public static void main(String[] args) {
//		Scanner c = new Scanner(System.in);
//		int n = c.nextInt(), t = 0;
//		String s = c.next();
//		for (int i = 0; i < n; i++) {
//			t += (int) s.charAt(i) - 48;
//		}
//		System.out.print(t);
//	}
//}