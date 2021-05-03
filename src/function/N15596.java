package function;
public class N15596 {

	static long sum(long[] a) {
		long ans = 0;
		for (int i = 0; i < a.length; i++) {
			ans += a[i];
		}
//		for (int i : a)
//			s += i;
		return ans;
	}

}