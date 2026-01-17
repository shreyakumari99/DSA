import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // 1. Sort the array to handle duplicates and enable pruning
        Arrays.sort(candidates);
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentPath, 
                           int[] candidates, int remaining, int start) {
        // Base Case: Success
        if (remaining == 0) {
            results.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: if the current number is larger than the remaining target, 
            // no need to check this or any subsequent numbers (since it's sorted)
            if (candidates[i] > remaining) {
                break;
            }

            // Skip duplicates: skip the same element if it's at the same depth
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Standard Backtracking
            currentPath.add(candidates[i]);
            // i + 1 because we cannot reuse the same element
            backtrack(results, currentPath, candidates, remaining - candidates[i], i + 1);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}