import java.util.Scanner;

public class N10809 {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(S.indexOf(ch) + " ");
		}
		
	}

}

//import java.io.*;
//import java.util.*;
//
//public class N10809{
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        String S = br.readLine();
//        int[] arr = new int[26];        
//       
//        for(int i = 0; i < arr.length; i++){            
//            arr[i] = -1;
//        }
//        for(int i = 0; i < S.length(); i++){
//            if(arr[S.charAt(i)-'a'] == -1){
//                arr[S.charAt(i)-'a'] = i;    
//            }
//        }
//        
//        for(int i = 0; i < arr.length; i++){            
//            sb.append(arr[i])
//                .append(" ");
//        }
//        br.close();
//        System.out.println(sb.toString());        
//    }
//}