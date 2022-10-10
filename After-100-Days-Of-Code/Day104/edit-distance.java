//Link: https://leetcode.com/problems/edit-distance/description/

//Time & Space: O(M*N) O(M*N)

class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int solve(String s1, String s2, int m, int n){
        String key = m+","+n;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        if(m==0) return n;
        if(n==0) return m;
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            dp.put(key, solve(s1, s2, m-1, n-1));
            return dp.get(key);
        }else{
            dp.put(key, 1 + Math.min(
                solve(s1, s2, m, n-1),
                Math.min(
                    solve(s1, s2, m-1, n),
                    solve(s1, s2, m-1, n-1)
                )
            ));
            return dp.get(key);
        }
    }
    public int minDistance(String word1, String word2) {
        return solve(word1, word2, word1.length(), word2.length());
    }
}
