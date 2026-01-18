import java.util.*;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        // Add all intervals that end before the new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // Add the merged new interval
        result.add(newInterval);
        
        // Add all remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        // Convert the list to a 2D array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        int[][] result1 = solution.insert(intervals1, newInterval1);
        System.out.println(Arrays.deepToString(result1));  // Output: [[1,5],[6,9]]

        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};
        int[][] result2 = solution.insert(intervals2, newInterval2);
        System.out.println(Arrays.deepToString(result2));  // Output: [[1,2],[3,10],[12,16]]
    }
}