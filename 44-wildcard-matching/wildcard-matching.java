public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int starIdx = -1;
        int matchIdx = 0;

        while (i < s.length()) {
            // Match character or '?'
            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            // Found '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                starIdx = j;
                matchIdx = i;
                j++;
            }
            // Mismatch but previous '*' exists → backtrack
            else if (starIdx != -1) {
                j = starIdx + 1;
                matchIdx++;
                i = matchIdx;
            }
            // No match and no '*'
            else {
                return false;
            }
        }

        // Remaining pattern must be all '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}
