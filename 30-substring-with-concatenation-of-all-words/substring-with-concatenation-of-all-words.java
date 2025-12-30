import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int n = s.length();
        int wordCount = words.length;
        int wordLen = words[0].length();
        int totalLen = wordCount * wordLen;

        // Map to store the frequency of each word in the input array
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        // Iterate through the word length to cover all possible alignments
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLen <= n) {
                // Extract the word at the right end of the window
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (counts.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have more of 'word' than required, shrink from the left
                    while (windowMap.get(word) > counts.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If the number of words matches, we found a valid index
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Not a valid word, reset the window
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}