class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        dfs(nums, 0, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, int target, int total, List<Integer> cur) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (var j = index; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }

            cur.add(nums[j]);
            dfs(nums, j, target, total + nums[j], cur);
            cur.remove(cur.size() - 1);
        }
    }
}

