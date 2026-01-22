import java.util.*;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + totalChars + 1 > maxWidth) break;
                totalChars += words[last].length() + 1;
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;

            // Not last line or single word line
            if (last != words.length && diff != 0) {
                int spaces = (maxWidth - totalChars) / diff;
                int extra = (maxWidth - totalChars) % diff;

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + (i - index < extra ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            } else {
                // Last line or single word line
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            }

            result.add(sb.toString());
            index = last;
        }

        return result;
    }

    public static void main(String[] args) {
       Solution tj = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(tj.fullJustify(words, maxWidth));
    }
}
