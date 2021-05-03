package function;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hanNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numberRange = Integer.parseInt(br.readLine());
		int number = 0;
		int count = 0;

		for (int i = 1; i <= numberRange; i++) {
			number = i;
			int tableOne = (number % 10);
			int tableTen = ((number % 100) / 10);
			int tableHundred;

			// 네 자리
			if (number >= 1000) {
				int tableThousand = (number / 1000);
				tableHundred = ((number / 100) % 10);				
				boolean checkThousands = (((tableTen - tableOne) == (tableHundred - tableTen))
						&& ((tableHundred - tableTen) == (tableThousand - tableHundred)));
				if (checkThousands) {
					count++;
				}
			// 세 자리 수
			} else if (1000 > number && number >= 100) {
				tableHundred = (number / 100);
				boolean checkHundreds = ((tableTen - tableOne) == (tableHundred - tableTen));
				if (checkHundreds) {
					count++;

				}
			// 1~99
			} else if (100 > number) {
				count++;
			}
		}
		System.out.println(count);
	}
}
