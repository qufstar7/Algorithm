package String;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		int count = N;

		// N���� �ܾ �Է¹ް� ���� ���ĺ�üũ boolean�� ����
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
			boolean[] AlphabetChk = new boolean[26];

			// �� �ܾ��� �� ��° ���ں��� ������ �� ��° ���ڱ��� �˻�
			for (int j = 1; j < str[i].length(); j++) {		
				
				// j-1 ��° ���ڰ� 0�� �� true��
				if ((j - 1) == 0) {
					AlphabetChk[str[i].charAt(j - 1) - 'a'] = true;
				}
				
				// j-1, j��° ���ڰ� ���� ���� ��
				if (str[i].charAt(j - 1) != str[i].charAt(j)) {
					int charLocation = str[i].charAt(j) - 'a';  // str[i].charAt(j) - 'a' �� j��° ������ ��ġ(a���� �Ÿ�) 
					
					// j��° ���ڰ� true�̸�(ù ��° ���ڿ� ������) count-1, �ƴϸ� j��° ���ڿ� �ش��ϴ� ���ĺ�üũ���ڸ� true��
					if (AlphabetChk[charLocation]) {
						count--;
						break;
					}
					AlphabetChk[charLocation] = true;
				}
			}
		}
		System.out.println(count);
	}
}