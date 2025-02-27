//Link: https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

//Time & Space: O(N*N) O(N*N)

class Solution
{
    public int LongestRepeatingSubsequence(String s1)
    {
        int ans = 0;
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];
        String s2 = s1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][n];
    }
}
