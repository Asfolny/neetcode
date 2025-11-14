class Solution {
    private PriorityQueue<Integer> heap;
    private int k;

    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        this.heap = new PriorityQueue<>(k+1);
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}

