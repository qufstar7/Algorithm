import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		String[] str = new String[N];	
		
		// �Է�
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		//�� �ݺ�	
		for (int i = 0; i < N; i++) {
			
			int count = 0; //���� Ƚ��
			int sum = 0; //���� �հ�
			
			//�� �ݺ�
			for (int j = 0; j < str[i].length(); j++) {
				if (str[i].charAt(j) == 'O') {
					count ++;
				} else { 
					count = 0;
				}
				sum += count;
			}
			System.out.println(sum);
		}
		
	}
}
