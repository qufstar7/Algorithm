package function;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numberRange = Integer.parseInt(br.readLine());
		int number = 0;
		int count = 0;

		for (int i = 1; i <= numberRange; i++) {
			number = i;
			int tableOne = (number % 10);
			int tableTen = ((number % 100) / 10);
			int tableHundred = (number / 100);

			if (number >= 100) {
				// �� �ڸ� ��
				boolean checkHundreds = ((tableTen - tableOne) == (tableHundred - tableTen));
				if (checkHundreds) {
					count++;
				}
			} else { //1, 2�ڸ� ���� ��� �Ѽ�
				count++;
			}
		}
		System.out.println(count);
	}
}
