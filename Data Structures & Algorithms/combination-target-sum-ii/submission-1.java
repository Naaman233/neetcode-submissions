class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if ( candidates == null) {
            return null;
        }
        Arrays.sort(candidates);
        compileCombination(0, result, new ArrayList<>(), 0, target,candidates);
        return result;
    }

    static void compileCombination(int start, List<List<Integer>> result,
     List<Integer> curr, int total, int target, int[] candidates) {
        if (total == target) {
            result.add(new ArrayList<>(curr));
        }

        if (total > target) {
            return;
        }

        int n = candidates.length;
        for (int i = start; i < n; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            curr.add(candidates[i]);
            compileCombination(i+1, result, curr, total + candidates[i], target, candidates);
            curr.remove(curr.size() -1);
        }
    }
}
