import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15552 {

	public static void main(String[] args) throws IOException {
		
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int T = Integer.parseInt(bReader.readLine());
			
			StringTokenizer st;
						
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(bReader.readLine()," ");
				bWriter.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
			}
			
			bReader.close();
			bWriter.flush();
			bWriter.close();		
		
	}

}
