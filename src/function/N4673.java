package function;
public class N4673 {

	static int numberRange = 10000;
	static int number;
	static int selfNumber;
	static int nonSelfNumber;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		boolean[] checkNonSelfNumber = new boolean[10001];
		
		// number ~ numberRange ������ nonSelfNumber�� ���Ѵ�
		for (number = 1; number <= numberRange; number++) {
			nonSelfNumber = nonSelfNumber(number);
			// NonSelfNumber(false)���� selfNumber(false)���� üũ�Ѵ�.
			if (nonSelfNumber <= 10000) {
				checkNonSelfNumber[nonSelfNumber] = true;
			}
		}

		// selfNumber�� ���		
		for (number = 1; number <= numberRange; number++) {
			if (!checkNonSelfNumber[number]) {
				selfNumber = number;
				sb.append(selfNumber).append('\n');
			}			
		}		
		System.out.println(sb);
	}

	// nonSelfNumber�� ���ϴ� �Լ�
	public static int nonSelfNumber(int number) {
		int sum = number;
		while (number != 0) {
			sum = sum + number % 10;
			number = number / 10;
			nonSelfNumber = sum;
		}
		return nonSelfNumber;
	}
}