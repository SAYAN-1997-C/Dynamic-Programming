package others;

public class TargetSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//				N = 6
//				arr[] = {3, 34, 4, 12, 5, 2}
//				sum = 9
//				Output: 1 
		int arr[] = {3,34,4,12,5,2};
		int sum=9;
		System.out.println(isSubsetSum(arr.length, arr, sum));
	}

	static Boolean isSubsetSum(int n, int arr[], int sum) {
		// code here
		boolean dp[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = false;
				} else {
					if (dp[i - 1][j]) {
						dp[i][j] = true;
					} else if (j >= arr[i - 1]) {
						if (dp[i - 1][j - arr[i - 1]]) {
							dp[i][j] = true;
						} else {
							dp[i][j] = false;
						}
					}
				}
			}
		}
		return dp[n][sum];
	}

}
