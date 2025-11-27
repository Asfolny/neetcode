class Solution {
    public int hammingWeight(int n) {
        var ones = 0;
        while (n != 0) {
            if ((n & 1) == 1) ones++;
            n = n >>> 1;
        }

        return ones;
    }
}

