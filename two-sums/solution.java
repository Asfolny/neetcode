class Solution {
    public int[] twoSum(int[] nums, int target) {
        var res = new int[2];
        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
                break;
            }

            map.put(nums[i], i);
        }

        return res;
    }
}

