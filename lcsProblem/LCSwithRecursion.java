package lcsProblem;

import java.math.*;

public class LCSwithRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip1="abcde";
		String ip2="ace";
		int m=ip1.length();
		int n =ip2.length();
		int res = LCS(ip1, ip2, m, n);
		System.out.println(res);
	}
	public static int LCS(String ip1,String ip2,int m,int n) {
		if(m==0 || n==0) {
			return 0;
		}
		if(ip1.charAt(m-1) == ip2.charAt(n-1)) {
			return 1+LCS(ip1, ip2, m-1, n-1);
		}
		return Math.max(LCS(ip1, ip2, m-1, n), LCS(ip1, ip2, m, n-1));
	}

}
