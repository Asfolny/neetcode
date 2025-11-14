class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        var sets = new HashSet<List<Integer>>();
        var set = new ArrayList<Integer>();
        dfs(nums, 0, target, set, sets);
        var res = new ArrayList<List<Integer>>();
        for (var subset : sets) {
            res.add(subset);
        }
        return res;
    }

    private void dfs(int[] nums, int index, int target, List<Integer> set, Set<List<Integer>> res) {
        var total = set.stream().reduce(0, Integer::sum);
        if (total >= target || index >= nums.length) {
            if (total == target) {
                res.add(new ArrayList<>(set));
            }
            return;
        }

        set.add(nums[index]);
        dfs(nums, index, target, set, res);
        dfs(nums, index+1, target, set, res);
        set.remove(set.size()-1);
        dfs(nums, index+1, target, set, res);
    }
}

