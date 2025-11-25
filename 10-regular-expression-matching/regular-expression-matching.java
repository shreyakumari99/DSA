class Solution {
    // Memoization cache to store results of subproblems
    private Boolean[][] memo;
    // Input strings
    private String text;
    private String pattern;
    // Lengths of input strings
    private int textLength;
    private int patternLength;

    /**
     * Determines if the entire string s matches the regular expression pattern p.
     * '.' matches any single character.
     * '*' matches zero or more of the preceding element.
     * 
     * @param s the input string to match
     * @param p the pattern with regular expression
     * @return true if s matches p, false otherwise
     */
    public boolean isMatch(String s, String p) {
        // Initialize lengths
        textLength = s.length();
        patternLength = p.length();
      
        // Initialize memoization cache with dimensions (textLength + 1) x (patternLength + 1)
        // to handle cases where indices reach the end of strings
        memo = new Boolean[textLength + 1][patternLength + 1];
      
        // Store input strings for use in recursive function
        this.text = s;
        this.pattern = p;
      
        // Start matching from the beginning of both strings
        return matchHelper(0, 0);
    }

    /**
     * Recursive helper function to check if substring starting at text[textIndex]
     * matches pattern starting at pattern[patternIndex].
     * 
     * @param textIndex current index in the text string
     * @param patternIndex current index in the pattern string
     * @return true if remaining substrings match, false otherwise
     */
    private boolean matchHelper(int textIndex, int patternIndex) {
        // Base case: if we've consumed the entire pattern
        if (patternIndex >= patternLength) {
            // Match is successful only if we've also consumed the entire text
            return textIndex == textLength;
        }
      
        // Check if this subproblem has already been solved
        if (memo[textIndex][patternIndex] != null) {
            return memo[textIndex][patternIndex];
        }
      
        boolean isMatch = false;
      
        // Check if the next character in pattern is '*' (Kleene star)
        if (patternIndex + 1 < patternLength && pattern.charAt(patternIndex + 1) == '*') {
            // Two options with '*':
            // Option 1: Match zero occurrences - skip current char and '*' in pattern
            isMatch = matchHelper(textIndex, patternIndex + 2);
          
            // Option 2: Match one or more occurrences
            // First check if current characters match, then try to match more
            if (!isMatch && textIndex < textLength) {
                char textChar = text.charAt(textIndex);
                char patternChar = pattern.charAt(patternIndex);
              
                if (textChar == patternChar || patternChar == '.') {
                    // Current chars match, consume text char and keep pattern position
                    isMatch = matchHelper(textIndex + 1, patternIndex);
                }
            }
        } else {
            // No '*' following current pattern character
            // Must match current characters exactly
            if (textIndex < textLength) {
                char textChar = text.charAt(textIndex);
                char patternChar = pattern.charAt(patternIndex);
              
                if (textChar == patternChar || patternChar == '.') {
                    // Characters match, move both pointers forward
                    isMatch = matchHelper(textIndex + 1, patternIndex + 1);
                }
            }
        }
      
        // Cache the result before returning
        memo[textIndex][patternIndex] = isMatch;
        return isMatch;
    }
}