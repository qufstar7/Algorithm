import java.io.IOException;

public class N2908 {

	public static void main(String[] args) throws IOException {

//		Scanner sc = new Scanner(System.in);
//		int[] numbers = new int[2];
//		int[] newNums = new int[2];
//		int max = newNums[1];
//		
//		for (int i = 0; i < numbers.length; i++) {
//			numbers[i] = sc.nextInt();
//			newNums[i] = ( 
//					((numbers[i] % 10) * 100) 
//					+ ((numbers[i] %100) /10) *10
//					+ (numbers[i] / 100) 
//					);			
//			if (newNums[0] > newNums[1]) {
//				max = newNums[0];
//			}
//		}
//
//		System.out.println(max);
		
		
		int A = 0, B = 0;
		A += System.in.read() - 48;
		A += (System.in.read() - 48) *10;
		A += (System.in.read() - 48) *100;
		System.in.read();
		B += System.in.read() - 48;
		B += (System.in.read() - 48) *10;
		B += (System.in.read() - 48) *100;
		
		System.out.println(A > B ? A : B);		
	}

}
