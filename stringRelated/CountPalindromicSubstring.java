package stringRelated;

public class CountPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPalinSubString("aaa"));
	}
	public static int countPalinSubString(String s) {
		int n = s.length();
		boolean dp[][] = new boolean[n][n];
		int count=0;
		for(int g=0;g<n;g++) {
			for(int i=0,j=g;j<n;j++,i++) {
				if(g==0) {
					dp[i][j] = true;
				}
				else if(g==1) {
					if(s.charAt(i)==s.charAt(j)) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
				else {
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
				
				if(dp[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

}
