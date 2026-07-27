class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        // Map to store the last seen index of each character
        int[] lastSeen = new int[128]; 
        
        // Fill array with -1 to indicate character hasn't been seen yet
        java.util.Arrays.fill(lastSeen, -1);

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character was seen before and is inside the current window
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1; // Move left boundary past the duplicate
            }

            // Update last seen index of the character
            lastSeen[currentChar] = right;

            // Calculate max window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}