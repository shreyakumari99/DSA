public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[sLen][pLen] = true;
        
        for (int i = sLen; i >= 0; i--) {
            for (int j = pLen - 1; j >= 0; j--) {
                boolean match = (i < sLen && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?'));
                if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j + 1] || (i < sLen && dp[i + 1][j]);
                } else {
                    dp[i][j] = match && dp[i + 1][j + 1];
                }
            }
        }
        
        return dp[0][0];
    }
}