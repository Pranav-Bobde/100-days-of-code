//Link: https://leetcode.com/problems/longest-increasing-subsequence/description/

//Time & Space: O(N^2) O(N)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = dp[0];
        for(int i : dp){
            res = Math.max(i, res);
        }
        return res;
    }
}
