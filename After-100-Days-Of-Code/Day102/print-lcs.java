//Link: https://ide.geeksforgeeks.org/75ad5491-8c7d-4fa5-81cb-73cb7f46527e

//Time & Space: O(N*M) O(N*M)

class GFG {
    public static void lcs(String s1, String s2, int n, int m){
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
                    j--;
                }else{
                    i--;
                }
            }
        }
        System.out.println(sb.toString());
    }
	public static void main (String[] args) {
		String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        lcs(X, Y, m, n);
	}
}
