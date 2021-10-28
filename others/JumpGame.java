package others;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,1,0,4};
		System.out.println(solution(arr));
	}
	
	public static int solution(int arr[]) {
		
		int n = arr.length;
		Integer dp[] = new Integer[n];
		dp[n-1]=0;
		
		for(int i=n-2;i>=0;i--) {
			int steps=arr[i];
			
			int min = Integer.MAX_VALUE;
			for(int j=1;j<=steps && j<n;j++) {
				if(dp[i+j]!=null && dp[i+j]<min) {
					min=dp[i+j];
				}
			}
			
			if(min != Integer.MAX_VALUE) {
				dp[i]=min+1;
			}
 		}
		return dp[0];
	}

}
