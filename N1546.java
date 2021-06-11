import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		String[] strArray = br.readLine().split(" ");
		
		double sum = 0 ;
		double max = 0;		
		double avgNew ;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strArray[i]);
			if (max < arr[i]) {
				max = arr[i]; 
			}			
			sum += (arr[i]);
		}		
		avgNew = sum/max*100/N ;
		
		System.out.println(avgNew);

	}

}
