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
// ### toCharArray를 사용하여 char배열로 더할 숫자리스트를 받고 Character.getNumericValue()로 숫자들을 더해 주었다. for (A :B){} 는 B에서 차례대로 객체를 꺼내서 A에다가 넣는 반복문. 

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
// ### 파싱 대신 (int) s.charAt(i) - '0'; (또는 string.charAt(i) - 48;) 으로 문자열을 정수타입으로 바꿀 수 있다. (파싱이 추천됨)

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