import java.util.HashSet;
import java.util.Scanner;

public class N3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			hs.add(sc.nextInt() % 42);
		}
		
		sc.close();
		System.out.println(hs.size());
		
		
		
		
		
//		List<String> arrList = new ArrayList<String>();
//		Scanner sc = new Scanner(System.in);
//
//		int arr[] = new int[10];
//		for (int i = 0; i < arr.length; i++) {
//			arrList.add(sc.nextLine());
//		}				
//		String splitList = arrList.split(", ");
//		int lO = arrList % 42;
//		for (int i = 0; i < arr.length; i++) {
//			
//		}	
//		
//		
//		sc.close();
//		System.out.println("List is " + arrList);
//		String[] arr = arrList.toArray(new String[0]);
//		System.out.println("Array is " + Arrays.toString(arr));

		
		
		
//		BufferedReader br = new BaufferedReader(new InputStreamReader(System.in));
//		int arr[] = new int[10]; 
//		for (int i = 0; i < arr.length; i++) {
//			String str = br.readLine(args[i]);;
//			
//		} 
//		System.out.println(str);
//		
//		int R1 = N1 % 42;
//		int R2 = N2 % 42;
//		int R3 = N3 % 42;
//		int R4 = N4 % 42;
//		int R5 = N5 % 42;
//		int R6 = N6 % 42;
//		int R7 = N7 % 42;
//		int R8 = N8 % 42;
//		int R9 = N9 % 42;
//		int R10 = N10 % 42;
//		int RN = N
//				
//		for (String Num : args) {
//			
//		}

	}

}