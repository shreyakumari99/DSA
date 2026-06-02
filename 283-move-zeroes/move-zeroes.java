class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // Tracks where the next non-zero should be placed
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap the non-zero element with the element at insertPos
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                
                // Move the insert position forward
                insertPos++;
            }
        }
    }
}