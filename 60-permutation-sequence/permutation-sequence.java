
public class Solution {
    public String getPermutation(int n, int k) {
        // Create a list of numbers from 1 to n
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Adjust k to be 0-indexed
        k--;
        
        // Initialize result
        StringBuilder result = new StringBuilder();
        
        // Calculate factorial
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        // Iterate through numbers
        for (int i = n; i > 0; i--) {
            // Calculate the index of the current number
            factorial /= i;
            int index = k / factorial;
            k %= factorial;
            
            // Append the current number to result
            result.append(numbers.get(index));
            numbers.remove(index);
        }
        
        return result.toString();
    }
}