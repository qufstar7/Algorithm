import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Scanner;

public class N1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		int copy = N; // ���� ����
		int count = 0;

		// �迭 ����
//		A = (N%10)*10 // N�� ���� �ڸ� ���� A�� ���� �ڸ� ��
//		A = (N/10 + N%10)%10 // N�� �� �ڸ� �� ���� ���� �ڸ� ���� A�� ���� �ڸ��� 		
//		A = (N%10)*10 + (N/10 + N%10)%10				
//		
//		// �迭 ���� 1�� : count �ϳ� �� �߰��ϸ� N �������ϴ� copy�� N�� ���� ���� break;
//		while (true) {
//			N = ((N%10)*10 + (N/10 + N%10)%10);
//			count++;
//			
//			if(copy == N) {
//				break;
//			}
//		}		
//		System.out.println(count);
//			
//		// �迭 ���� 2�� : count ���� N ������ copy�� N�� ���� ���� ���� �ݺ�
//		do {
//			N = ((N%10)*10 + (N/10 + N%10)%10);
//			count++;
//		} while(copy != N);
//		
//		System.out.println(count);
//		
//		
//				
//	    // �迭��
//		A[0] = N[1] // N�� ���� �ڸ� ���� A�� ���� �ڸ� ��
//		A[1] = N[0]+N[1] // N�� ���� �ڸ� ���� A�� ���� �ڸ� ���� ���� �ڸ� ���� ��
		ArrayList<Integer> data = new ArrayList<Integer>(2);
		if (N < 10) {
			data.add(0);
			data.add(N);
		} else {
			data.add(N / 10);
			data.add(N % 10);
		}
		
		while (true) {
			count++;
			int i3 = data.get(0) + data.get(1);
			i3 = i3 % 10;
			data.set(0, data.get(1));
			data.set(1, i3);
			if (N / 10 == data.get(0) && N % 10 == data.get(1))
				break;

		}

		System.out.println(count);

	}
}
