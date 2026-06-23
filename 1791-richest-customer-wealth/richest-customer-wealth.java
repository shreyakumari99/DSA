class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        
        // Iterate through each customer (row)
        for (int[] customer : accounts) {
            int currentWealth = 0;
            
            // Sum up the money in all banks for the current customer
            for (int bankBalance : customer) {
                currentWealth += bankBalance;
            }
            
            // Update maxWealth if the current customer is richer
            maxWealth = Math.max(maxWealth, currentWealth);
        }
        
        return maxWealth;
    }
}