import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11654 {	
	
	static int numberRange = 9;	
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char input = br.readLine().charAt(0);
		int asciiValue = (int)input;
		
		System.out.println(asciiValue);
		
	}	
}

	// fast-program
//import java.io.IOException;
//public class N11654 {
//    public static void main(String[] args) throws IOException  {
//        int asciiValue = System.in.read();
//        System.out.print(asciiValue-48);
//    }
//}

	// short-coding
//class N11654 {
//	public static void main(String[] args) throws Exception {
//		System.out.print(System.in.read());
//	}
//}