class Solution { // 1. Opens the class
    public double average(int[] salary) { // 2. Opens the method
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int s : salary) {
            sum += s;
            if (s < min) {
                min = s;
            }
            if (s > max) {
                max = s;
            }
        }

        int remainingSum = sum - min - max;
        int remainingCount = salary.length - 2;

        return (double) remainingSum / remainingCount;
    } // 2. Closes the method
} // 1. Closes the class

// <-- If there is a 3rd '}' here, delete it!