package pathRelated;

import java.util.ArrayDeque;

class Pair {
	String psf;
	int i;
	int j;
	Pair(String psf,int i,int j) {
		this.psf=psf;
		this.i=i;
		this.j=j;
	}
}

public class PathWithMaximumGold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1}};
		solution(arr);
	}

	public static void solution(int arr[][]) {
		int n = arr.length;
		int m = arr[0].length;
		int dp[][] = new int[n][m];

		for (int j = m - 1; j >= 0; j--) {
			for (int i = 0; i < n; i++) {
				if (j == m - 1) {
					dp[i][j] = arr[i][j];
				} else if (i == 0) {
					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
				} else if (i == n - 1) {
					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
				} else {
					dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j + 1], Math.max(dp[i][j + 1], dp[i - 1][j + 1]));
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (dp[i][0] > max) {
				max = dp[i][0];
			}
		}
		System.out.println(max);
		
		ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
		for(int i=0;i<n;i++) {
			if(dp[i][0] == max) {
				queue.add(new Pair(""+i, i, 0));
			}
		}
		
		while(queue.size() > 0) {
			Pair rem = queue.remove();
			
			int i=rem.i,j=rem.j;
			if(j==m-1) {
				System.out.println(rem.psf);
			}
			
			else if(i==0) {
				if(dp[i][j+1] > dp[i+1][j+1]) {
					queue.add(new Pair(rem.psf+" D2", i, j+1));
				} else {
					queue.add(new Pair(rem.psf+" D3", i+1, j+1));
				}
			} else if(i==n-1) {
				if(dp[i][j+1] > dp[i-1][j+1]) {
					queue.add(new Pair(rem.psf+" D2", i, j+1));
				} else {
					queue.add(new Pair(rem.psf+" D1", i-1, j+1));
				}
			} else {
				int x = Math.max(dp[i + 1][j + 1], Math.max(dp[i][j + 1], dp[i - 1][j + 1]));
				if(dp[i - 1][j + 1] == x) {
					queue.add(new Pair(rem.psf+" D1", i-1, j+1));
				} 
				if(dp[i][j+1] == x) {
					queue.add(new Pair(rem.psf+" D2", i, j+1));
				}
				if(dp[i+1][j+1] == x) {
					queue.add(new Pair(rem.psf+" D3", i+1, j+1));
				}
			}
		}
	}
}
