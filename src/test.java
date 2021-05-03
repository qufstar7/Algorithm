import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test { //Fly me to the Alpha Centauri

	public static void main(String[] args) throws IOException{

		ArrayList<Boolean> primeList;
		
		int n = 100;
		
		primeList = new ArrayList<Boolean>(n + 1);
		primeList.add(false);
		primeList.add(false);
		for (int i = 2; i <= n; i++)
			primeList.add(i, true);
		
		for (int i = 2; (i * i) <= n; i++) {
			if (primeList.get(i)) {
				for (int j = i * i; j <= n; j += i)
					primeList.set(j, false);
			}
		}
	}
}