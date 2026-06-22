class Solution {
    public boolean isRobotBounded(String instructions) {
        // Directions array mapped clockwise: North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Initial position and direction (0 corresponds to North)
        int x = 0, y = 0;
        int idx = 0; 
        
        for (char i : instructions.toCharArray()) {
            if (i == 'R') {
                idx = (idx + 1) % 4; // Turn clockwise
            } else if (i == 'L') {
                idx = (idx + 3) % 4; // Turn counter-clockwise (equivalent to +3 clockwise)
            } else {
                // Move straight in the current direction
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }
        
        // Bounded if returned to origin OR not facing North
        return (x == 0 && y == 0) || (idx != 0);
    }
}