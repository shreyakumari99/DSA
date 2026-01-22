import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return stack.isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/")); // Output: "/home"
        System.out.println(solution.simplifyPath("/home//foo/")); // Output: "/home/foo"
        System.out.println(solution.simplifyPath("/home/user/Documents/../Pictures")); // Output: "/home/user/Pictures"
        System.out.println(solution.simplifyPath("/../")); // Output: "/"
        System.out.println(solution.simplifyPath("/.../a/../b/c/../d/./")); // Output: "/.../b/d"
    }
}