class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        var set = new ArrayList<Integer>();
        dfs(nums, 0, target, set);
        return res;
    }

    private void dfs(int[] nums, int index, int target, List<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }

        if (target < 0 || index >= nums.length) {
            return;
        }

        cur.add(nums[index]);
        dfs(nums, index, target - nums[index], cur);
        cur.remove(cur.size()-1);
        dfs(nums, index+1, target, cur);
    }
}

