import java.util.Scanner;

public class N2577 {
	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in); 
		int result = (in.nextInt() * in.nextInt() * in.nextInt());
		String str = Integer.toString(result);
		in.close();
		
		for (int i = 0; i < 10; i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if ((str.charAt(j) - '0') == i) {
					count++;
				}
			}
			System.out.println(count);
		}		
		
		//´ä2
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int a, b, c, result;
//		a = Integer.parseInt(br.readLine());
//		b = Integer.parseInt(br.readLine());
//		c = Integer.parseInt(br.readLine());
//		result = a*b*c;
//		String resultStr = "";
//		resultStr = String.valueOf(result);
//		int arr[] = new int[10];
//		for (int i = 0; i < resultStr.length(); i++) {
//			int num = Integer.parseInt(resultStr.substring(i, i + 1));
//			for (int j = 0; j < arr.length; j++) {
//				if (num == j) {
//					arr[j]++;
//				}
//			}
//		}
//		for (int k = 0; k < arr.length; k++) {
//			System.out.println(arr[k]);
//		}
		
		//´ä3
//		int [] arr = new int [10];
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
//		while(N != 0) {
//			arr[N % 10]++;
//			N /= 10;
//		}
//		for(int x : arr) {
//			System.out.println(x);
//		}		
		
	}
}