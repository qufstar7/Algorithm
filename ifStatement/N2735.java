
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2735 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double Y = Double.parseDouble(br.readLine());
		if ((Y % 4) == 0) {
			if ((Y % 100) == 0 && (Y % 400) != 0) {
				System.out.println("0");
			} else {
				System.out.println("1");
			}
		} else {
			System.out.println("0");
		}

	}
}
