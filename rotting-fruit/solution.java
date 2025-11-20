class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        var time = 0;
        var queue = new ArrayDeque<int[]>();

        // find first rot
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        while (!queue.isEmpty()) {
            var queueLen = queue.size();
            var rotten = false;

            for (int i = 0; i < queueLen; i++) {
                var rot = queue.remove();
                int r = rot[0], c = rot[1];

                var neighbors = new int[][] {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};
                for (var n : neighbors) {
                    r = n[0];
                    c = n[1];
                    if (
                        Math.min(r, c) < 0 ||
                        r == ROWS || c == COLS ||
                        grid[r][c] != 1
                    ) {
                        continue;
                    }

                    queue.add(new int[] {r, c});
                    grid[r][c] = 2;
                    rotten = true;
                }
            }

            // Only if we actually rotted one, can we add a minute
            // This ensure no n+1 from the last rotting (the last healthy has been rotted, but we still have to check if it can rot more)
            // This + default time of 0 also ensures that a matrix with no oranges at all, will return 0
            if (rotten) time++;
        }

        // Ensure no healthy left
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}

