package pathRelated;

import java.util.ArrayDeque;

class Pair {
	String psf;
	int i;
	int j;
	int cost;
	Pair(String psf,int i,int j,int cost) {
		this.psf=psf;
		this.i=i;
		this.j=j;
		this.cost=cost;
	}
}

public class AllMinimumCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]= {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(solution(grid));
	}
	public static int solution(int[][] grid) {
		int n=grid.length;
        int m=grid[0].length;
        
        int dp[][]=new int[n][m];
        
        for(int i=n-1;i>=0;i--) {
            for(int j=m-1;j>=0;j--) {
                if(i==n-1 && j==m-1) {
                    dp[i][j]=grid[i][j];
                } else if(i==n-1) {
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                } else if(j==m-1) {
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                } else {
                    int min = Math.min(dp[i+1][j],dp[i][j+1]);
                    dp[i][j]=min+grid[i][j];
                }
            }
        }
        
        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.add(new Pair("", 0, 0, 20));
        
        while(queue.size() > 0) {
        	Pair rem = queue.remove();
        	
        	int i=rem.i,j=rem.j;
        	if(i==n-1 && j==n-1) {
        		System.out.println(rem.psf);
        	}
        	else if(i == n-1) {
        		queue.add(new Pair(rem.psf+"H",i,j+1,dp[i][j+1]));
        	}
        	else if(j == m-1) {
        		queue.add(new Pair(rem.psf+"V",i+1,j,dp[i+1][j]));
        	} else {
        		if(dp[i][j+1] < dp[i+1][j] && i+1 < n && j+1 < m) {
            		queue.add(new Pair(rem.psf+"H",i,j+1,dp[i][j+1]));
            	} else if(dp[i+1][j] < dp[i][j+1] && i+1 < n && j+1 < m) {
            		queue.add(new Pair(rem.psf+"V",i+1,j,dp[i+1][j]));
            	} else {
            		queue.add(new Pair(rem.psf+"H",i,j+1,dp[i][j+1]));
            		queue.add(new Pair(rem.psf+"V",i+1,j,dp[i+1][j]));
            	}
        	}
        }
        
        
        return dp[0][0];
	}

}
