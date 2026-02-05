class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // Optimization: A valid IP can't be shorter than 4 or longer than 12 digits
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPath, List<String> result) {
        // Base case: If we have 4 segments, check if we've used all characters
        if (currentPath.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", currentPath));
            }
            return;
        }

        // Try lengths 1, 2, and 3 for the next segment
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            // Validation:
            // 1. No leading zeros: if length > 1, first char cannot be '0'
            // 2. Value: must be between 0 and 255
            if ((segment.startsWith("0") && segment.length() > 1) || 
                (len == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }

            currentPath.add(segment);
            backtrack(s, start + len, currentPath, result);
            currentPath.remove(currentPath.size() - 1); // Backtrack
        }
    }    
}