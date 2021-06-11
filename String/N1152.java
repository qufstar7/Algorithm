import java.io.*;
import java.util.*;

public class N1152 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		List<String> list = new ArrayList<String>(Arrays.asList(str));		
		list.remove("");
		System.out.println(list.size());

//		public class N1152 {
//			public static void main(String[] $) {
//		System.out.println(new java.util.Scanner(System.in).useDelimiter("\\s+").tokens().count());
//			}
//		}
	}

}
