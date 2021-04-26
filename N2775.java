package basicMath1;

import java.io.*;

public class N2775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[][] arr = new int[15][16];
		for (int i = 0; i <= 14; i++) {
			arr[i][1] = 1;
			arr[0][i + 1] = i + 1;
		}

		for (int a = 0; a < T; a++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
				}
			}
			sb.append(arr[k][n] + "\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}

}
