import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        // Sort the array to easily check the largest elements first
        Arrays.sort(nums);
        
        // Start from the end of the array and check triplets
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                // Found the largest valid triangle
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        
        // If no valid triangle can be formed
        return 0;
    }
}