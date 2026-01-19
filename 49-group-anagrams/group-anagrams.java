
import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(solution.groupAnagrams(strs1));  // Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
        
        String[] strs2 = {""};
        System.out.println(solution.groupAnagrams(strs2));  // Output: [[""]]
        
        String[] strs3 = {"a"};
        System.out.println(solution.groupAnagrams(strs3));  // Output: [["a"]]
    }
}