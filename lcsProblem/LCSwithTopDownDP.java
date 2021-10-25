package lcsProblem;

public class LCSwithTopDownDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ip1="abcde";
		String ip2="abce";
		int res = LCS(ip1, ip2);
		System.out.println(res);
		String str = lcsString(ip1, ip2);
		System.out.println(str);
	}
	public static int LCS(String ip1,String ip2) {
		int m=ip1.length();
		int n=ip2.length();
		int dp[][]= new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}
			}
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(ip1.charAt(i-1) == ip2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					if(dp[i-1][j] > dp[i][j-1]) {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		return dp[m][n];
	}
	public static String lcsString(String ip1,String ip2) {
		int m=ip1.length();
		int n=ip2.length();
		int dp[][]= new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}
			}
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(ip1.charAt(i-1) == ip2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					if(dp[i-1][j] > dp[i][j-1]) {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		int i=m;
		int j=n;
		String res = "";
		while(i>0 && j>0) {
			if(ip1.charAt(i-1)==ip2.charAt(j-1)) {
				res = ip1.charAt(i-1)+res;
				i--;
				j--;
			}
			else {
				if(dp[i-1][j] > dp[i][j-1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		return res;
	}

}
