import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        
        // 2. Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // 3. Check for overlap
            if (nextStart <= currentEnd) {
                // There is an overlap; update the end of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap; move to the next interval and add it to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // 4. Convert List back to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}