class Solution {
    public int[] twoSum(int[] nums, int target) {
        var res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                var attempt = nums[i] + nums[j];
                if (attempt == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }
}

