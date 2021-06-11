import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2439 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			for (int k = 1; k <= i; k++) {						
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
