package lcsProblem;

import java.math.*;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcde";
		String s2="ace";
		String res = ShrtCommonSuperSequence(s1, s2);
		System.out.println(res);

	}
	public static String ShrtCommonSuperSequence(String s1,String s2) {
		int m=s1.length();
		int n=s2.length();
		int dp[][]=new int[m+1][m+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}
			}
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j]=1+dp[i-1][j-1];
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
		String res="";
		int i=m;
		int j=n;
		while(i>0 && j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				res=s1.charAt(i-1)+res;
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1]){
				res=s1.charAt(i-1)+res;
				i--;
			}
			else {
				res=s2.charAt(j-1)+res;
				j--;
			}
		}
		System.out.println(i);
		System.out.println(j);
		while(i>0) {
			res=s1.charAt(i-1)+res;
			i--;
		}
		while(j>0) {
			res=s2.charAt(j-1)+res;
			j--;
		}
		return res;
 	}

}
