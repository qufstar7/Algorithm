package basicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3053 { // 택시 기하학

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double R = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(R * R * Math.PI).append("\n").append(R * R * 2);
		System.out.println(sb);
	
	}

}
