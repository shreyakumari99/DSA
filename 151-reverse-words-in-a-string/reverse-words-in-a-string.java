public class Solution {
    public String reverseWords(String s) {
        // Remove leading and trailing spaces
        s = s.trim();

        // Split the string into words
        String[] words = s.split("\\s+");

        // Reverse the words array
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        // Join the words with a single space
        return String.join(" ", words);
    }
}