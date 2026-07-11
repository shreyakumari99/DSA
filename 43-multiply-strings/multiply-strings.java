class Solution {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        
        // Loop backwards through both strings
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Convert chars to numbers and multiply
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                // Determine the array positions
                int p1 = i + j;
                int p2 = i + j + 1;
                
                // Add current multiplication to the existing value at position p2
                int sum = mul + result[p2];
                
                // Update positions with carry and remainder
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        
        // Build the final string representation
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // Skip leading zeros
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        return sb.toString();
    }
}