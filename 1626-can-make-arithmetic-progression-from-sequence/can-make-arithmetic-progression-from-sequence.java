import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Calculate the expected difference between consecutive elements
        int diff = arr[1] - arr[0];
        
        // Step 3: Check if all other adjacent pairs have the exact same difference
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        
        return true;
    }
}