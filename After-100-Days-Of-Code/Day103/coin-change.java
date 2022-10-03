//Link: https://practice.geeksforgeeks.org/problems/coin-change2448/1

//Time & Space: O(N*SUM) O(N*SUM)

class Solution {
    public long count(int coins[], int N, int sum) {
        long[][] dp = new long[sum+1][N+1];
        for(int j=0; j<=N; j++)
            dp[0][j] = 1;
        for(int i=1; i<=sum; i++){
            for(int j=1; j<=N; j++){
                dp[i][j] = dp[i][j-1];
                if(coins[j-1]<=i){
                    dp[i][j]+=dp[i-coins[j-1]][j];
                }
            }
        }
        return dp[sum][N];
    }
}
