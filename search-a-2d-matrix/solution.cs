public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] > target) return false;

        var relevantRow = -1;

        for (int i = 0; i < matrix.Length; i++) {
            var cur = matrix[i];
            if (cur[cur.Length-1] == target) {
                return true;
            } else if (cur[cur.Length-1] > target) {
                relevantRow = i;
                break;
            }
        }

        if (relevantRow == -1) return false;

        var row = matrix[relevantRow];
        var left = 0;
        var right = row.Length-1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (target > row[mid]) {
                left = mid + 1;
            } else if (target < row[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}

