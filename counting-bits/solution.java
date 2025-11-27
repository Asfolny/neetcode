class Solution {
    public int[] countBits(int n) {
        var res = new int[n+1];

        for (int i = 0; i <= n; i++)
            res[i] = hammingWeight(i);

        return res;
    }

    private int hammingWeight(int n) {
        var ones = 0;

        while (n != 0) {
            if ((n & 1) == 1)
                ones++;
            n = n >>> 1;
        }

        return ones;
    }
}

