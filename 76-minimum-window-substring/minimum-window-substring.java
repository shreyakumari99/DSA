import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int requiredChars = tCount.size();
        int formedChars = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0}; // {window length, start, end}

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (tCount.containsKey(c) && windowCounts.get(c).equals(tCount.get(c))) {
                formedChars++;
            }

            while (left <= right && formedChars == requiredChars) {
                c = s.charAt(left);

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tCount.containsKey(c) && windowCounts.get(c) < tCount.get(c)) {
                    formedChars--;
                }

                left++;
            }
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}    