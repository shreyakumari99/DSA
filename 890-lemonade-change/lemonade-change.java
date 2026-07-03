class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                // No change needed, just accept the bill
                five++;
            } else if (bill == 10) {
                // Must give a $5 bill as change
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else { // bill == 20
                // Prefer giving one $10 and one $5 as change (Greedy)
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    // Fallback to giving three $5 bills
                    five -= 3;
                } else {
                    // Cannot provide $15 change
                    return false;
                }
            }
        }

        return true;
    }
}