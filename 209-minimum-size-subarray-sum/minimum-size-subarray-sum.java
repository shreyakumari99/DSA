class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Shrink the window as much as possible while the sum >= target
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        // Return 0 if no valid subarray was found, otherwise return minLength
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}