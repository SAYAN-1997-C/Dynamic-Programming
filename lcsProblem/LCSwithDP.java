package lcsProblem;

import java.math.*;

public class LCSwithDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip1="abcde";
		String ip2="abcee";
		int m=ip1.length();
		int n=ip2.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				dp[i][j]=-1;
			}
		}
		int res = LCS(ip1, ip2, m, n, dp);
		System.out.println(res);
	}
	public static int LCS(String ip1,String ip2,int m,int n,int dp[][]) {
		if(m==0 || n==0) {
			return 0;
		}
		if(dp[m][n]!=-1) {
			return dp[m][n];
		}
		if(ip1.charAt(m-1) == ip2.charAt(n-1)) {
			return dp[m][n] = 1+LCS(ip1, ip2, m-1, n-1, dp);
		}
		return dp[m][n] = Math.max(LCS(ip1, ip2, m-1, n, dp), LCS(ip1, ip2, m, n-1, dp));
	}

}
