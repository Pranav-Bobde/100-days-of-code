//Link: https://leetcode.com/problems/longest-increasing-subsequence/description/

//Time & Space: O(NlogN) O(N)
class Solution {
    public int findCeil(int[] arr, int l, int r, int x){
        while(l<r){
            int m = l + (r-l)/2;
            if(arr[m] >= x){
                r = m;
            }else{
                l = m+1;
            }
        }
        return r;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];
        tail[0] = nums[0];
        int len = 1;
        for(int i=1; i<n; i++){
            if(nums[i] > tail[len-1]){
                tail[len++] = nums[i];
            }else{
                int ceilIdx = findCeil(tail, 0, len-1, nums[i]);
                tail[ceilIdx] = nums[i];
            }
        }
        return len;
    }
}

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
