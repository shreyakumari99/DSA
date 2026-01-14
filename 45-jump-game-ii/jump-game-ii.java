class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        
        int jumps = 0;
        int currEnd = 0;
        int currFarest = 0;
        
        for (int i = 0; i < n - 1; i++) {
            currFarest = Math.max(currFarest, i + nums[i]);
            
            if (i == currEnd) {
                jumps++;
                currEnd = currFarest;
            }
        }
        
        return jumps;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums1));  // Output: 2
        
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums2));  // Output: 2
    }
}