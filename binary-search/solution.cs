public class Solution {
    public int Search(int[] nums, int target) {
        return RecSearch(nums, 0, nums.Length-1, target);
    }

    private int RecSearch(int[]nums, int left, int right, int target) {
        if (left >= right)
            return nums[left] == target ? left : -1;

        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        
        return nums[mid] > target ?
            RecSearch(nums, left, mid-1, target) : 
            RecSearch(nums, mid+1, right, target);
    }
}

