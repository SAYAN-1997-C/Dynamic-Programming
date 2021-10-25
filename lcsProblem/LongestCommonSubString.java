package lcsProblem;

public class LongestCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S1 = "ABCDGH", S2 = "ACDGHR";
		System.out.println(longestCommonSubstr(S1, S2, S1.length(), S2.length()));
	}
	public static int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int mx=0;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j]=0;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    mx=Math.max(mx,dp[i][j]);
                } else {
                    dp[i][j]=0;
                }
            }
        }
        return mx;
    }

}
