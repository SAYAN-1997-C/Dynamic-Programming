package lcsProblem;

public class MinDelPerformGetStringPalidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aebcbda";
		System.out.println(minDeletions(s));

	}
	public static int minDeletions(String s) {
		int m = s.length();
		StringBuilder str = new StringBuilder(s);
		String s2=str.reverse().toString();
		int dp[][] = new int [m+1][m+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=m;j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				} else if (s.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return m-dp[m][m];
	}

}
