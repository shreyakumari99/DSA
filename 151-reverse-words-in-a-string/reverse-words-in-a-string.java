class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // Remove leading and trailing spaces
        String[] words = s.split("\\s+"); // Split into words
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words); // Join words in reverse order
    }
}