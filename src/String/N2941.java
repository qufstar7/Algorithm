package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2941 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String[] croatiaAlphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		for (String Alphabet : croatiaAlphabet) {
			str = str.replaceAll(Alphabet, "*");
		}
		System.out.println(str.length());
	}

}