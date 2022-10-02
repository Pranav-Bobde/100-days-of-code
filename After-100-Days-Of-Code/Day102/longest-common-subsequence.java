//Link: https://leetcode.com/problems/longest-common-subsequence/description/

//Time & Space: O(M*N) O(M*N)

class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int ans = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
