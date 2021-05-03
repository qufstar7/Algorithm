package oneDimensionalArray;
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

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//
//public class N2562 {
//
//	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		int A = 0;
//		int count = 0;
//		
//		try {
//			for(int i= 0 ; i<9;i++){
//				int input = Integer.parseInt(br.readLine());
//				if(i==0){ //처음에 입력된 값을 저장
//					A = i;
//					count = input;
//				}else{
//					if(count<input){// 저장한 값와 다음에 입력된 값을 비교 후 입력된 값이 클경우에 입력된 값을 저장합니다.
//						count = input;
//						A=i; //배열의 번호를 저장
//					}
//				}
//			}
//			
//			bw.write(String.valueOf(count));
//			bw.newLine();
//			bw.write(String.valueOf(A+1)); //배열의 번호가 0부터 시작함으로 +1을 하여줍니다.
//		} catch (IOException e) {			
//			e.printStackTrace();
//		} finally {
//			try {
//				if (br != null) {
//					br.close();
//				}
//				if (bw != null) {
//					bw.flush();
//					bw.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}

//import java.io.*;
//import java.util.StringTokenizer;
//
//public class N2562 {
//	public static void main(String[] args) throws IOException {
//		int[] arr = new int[9];
//		int max = 0;
//		int num = 0;
//		int cycle = 0;
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		for (int i = 0; i < 9; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			arr[i] = Integer.parseInt(st.nextToken());
//			if (i == 0) {
//				max = arr[i];
//			} else if (i > 0 && max < arr[i]) {
//				max = arr[i];
//				cycle = num;
//			}
//			num++;
//		}
//		System.out.println(max);
//		System.out.println(cycle + 1);
//	}
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2562{
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] array = new int[9];
		int max = 0, index=0;
		
		for(int i=0; i<9; i++) {
			array[i] = Integer.parseInt(br.readLine());
			
			if(array[i]>max) {
				max = array[i];
				index = i;
			}
		}
		sb.append(max).append("\n").append(index+1);
		System.out.println(sb);
	}
}