class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < n; i++) {
                heights[i] = row[i] == '0' ? 0 : heights[i] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int height = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }

        return maxArea;
    }
}