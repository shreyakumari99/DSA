class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        // If the needle is longer than the haystack, it can't be found.
        if (m < n) {
            return -1;
        }
        
        // Loop through the haystack
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            
            // Check the characters one by one
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            
            // If j reached the length of needle, we found a complete match
            if (j == n) {
                return i;
            }
        }
        
        // If we get through the whole loop without returning, there is no match
        return -1;
    }
}