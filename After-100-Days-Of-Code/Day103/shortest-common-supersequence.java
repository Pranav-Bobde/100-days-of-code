//Link: https://leetcode.com/problems/shortest-common-supersequence/description/

//Time & Space: O(M*N) O(M*N)

class Solution {
    public String lcs(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i=n, j=m;
        StringBuilder sb = new StringBuilder();
        while(i>0&&j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.insert(0, s1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i][j-1]>dp[i-1][j]){
                    sb.insert(0, s2.charAt(j-1));
                    j--;
                }else{
                    sb.insert(0, s1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0)
            sb.insert(0, s1.charAt((i--)-1));
        while(j>0)
            sb.insert(0, s2.charAt((j--)-1));
        return sb.toString();
    }
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        return lcs(s1, s2, n, m);
    }
}
