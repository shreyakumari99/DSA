class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for target string t
        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        // Frequency map for current window
        int[] windowCount = new int[128];
        
        int requiredUniqueChars = 0;
        for (int count : targetCount) {
            if (count > 0) {
                requiredUniqueChars++;
            }
        }

        int formedUniqueChars = 0;
        int left = 0, right = 0;
        
        // Track the smallest valid substring: {windowLength, startIdx}
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {
            // Expand the window
            char rightChar = s.charAt(right);
            windowCount[rightChar]++;

            // Check if current character completes the count for this character
            if (targetCount[rightChar] > 0 && windowCount[rightChar] == targetCount[rightChar]) {
                formedUniqueChars++;
            }

            // Shrink the window from the left as long as it remains valid
            while (left <= right && formedUniqueChars == requiredUniqueChars) {
                // Update minimum length found so far
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Remove the left character from window
                char leftChar = s.charAt(left);
                windowCount[leftChar]--;

                if (targetCount[leftChar] > 0 && windowCount[leftChar] < targetCount[leftChar]) {
                    formedUniqueChars--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}