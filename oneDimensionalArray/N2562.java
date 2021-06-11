//import java.util.Scanner;
//public class N2562 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);		
//		int[] arr = new int[9];
//		int max = arr[0];
//		int counter = -1;		
//		for (int i = 0; i < arr.length; i++) {	
//			arr[i] = sc.nextInt();
//			if (max < arr[i]) {
//				max = arr[i];
//			}
//			counter++;
//		}
//		sc.close();
//		System.out.println(max);
//		System.out.println(counter);
//	}
//}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2562 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int idx = 0;
		int value = 0;
		
		try {
			for(int i= 0 ; i<9;i++){
				int input = Integer.parseInt(br.readLine());
				if(i==0){ //ó���� �Էµ� ���� ����
					idx = i;
					value = input;
				}else{
					if(value<input){// ������ ���� ������ �Էµ� ���� �� �� �Էµ� ���� Ŭ��쿡 �Էµ� ���� �����մϴ�.
						value = input;
						idx=i; //�迭�� ��ȣ�� ����
					}
				}
			}
			
			bw.write(String.valueOf(value));
			bw.newLine();
			bw.write(String.valueOf(idx+1)); //�迭�� ��ȣ�� 0���� ���������� +1�� �Ͽ��ݴϴ�.
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.flush();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}