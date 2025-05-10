public class Solution {
    public void SortColors(int[] nums) {
        var buckets = new int[] { 0, 0, 0 };
        foreach (var num in nums) {
            buckets[num]++;
        }

        var bucketIdx = 0;
        for (int i = 0; i < nums.Length; i++) {
            while (buckets[bucketIdx] == 0) {
                bucketIdx++;
            }
            nums[i] = bucketIdx;
            buckets[bucketIdx]--;
        }
    }
}
