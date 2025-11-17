class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        var largest = 0;
        for (int c = 0; c < grid[0].length; c++) {
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] != 1) continue;
                var size = swallow(r, c, grid);
                if (size > largest) {
                    largest = size;
                }
            }
        }

        return largest;
    }

    private int swallow(int r, int c, int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        grid[r][c] = 0;
        var counter = 1;
        
        if (r + 1 < ROWS && grid[r + 1][c] == 1)
            counter += swallow(r + 1, c, grid);
        if (r - 1 >= 0 && grid[r - 1][c] == 1)
            counter += swallow(r - 1, c, grid);
        if (c + 1 < COLS && grid[r][c + 1] == 1)
            counter += swallow(r, c + 1, grid);
        if (c - 1 >= 0 && grid[r][c - 1] == 1)
            counter += swallow(r, c - 1, grid);
        return counter;
    }
}

