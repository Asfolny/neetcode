class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = Arrays.stream(piles).max().getAsInt();
        int low = 1;

        if (h == piles.length) {
            return high;
        }

        while (low < high) {
            int mid = (low / 2) + (high / 2);
            int hoursForMid = Arrays.stream(piles).reduce(0, (acc, num) -> (int)Math.ceil((double)num / mid) + acc);

            if (hoursForMid < 0) {
                return high; // overflow, too far
            }

            if (hoursForMid > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}

