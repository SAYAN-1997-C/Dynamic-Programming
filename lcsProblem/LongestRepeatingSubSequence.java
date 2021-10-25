package lcsProblem;

public class LongestRepeatingSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "axxxy";
		System.out.println(longestRepeatingSubsequence(str));

	}
	public static int longestRepeatingSubsequence(String str)
    {
        // code here
        String s2 = str;
        int m=str.length();
        int dp[][]=new int[m+1][m+1];
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                } else if(str.charAt(i-1)==s2.charAt(j-1) && i!=j) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][m];
    }

}
