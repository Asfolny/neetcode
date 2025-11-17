class Solution {
    public int numIslands(char[][] grid) {
        var islands = 0;
        for (int c = 0; c < grid[0].length; c++) {
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] != '1') continue;
                islands++;
                swallow(r, c, grid);
            }
        }

        return islands;
    }

    private void swallow(int r, int c, char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        grid[r][c] = '0';
        
        if (r + 1 < ROWS && grid[r + 1][c] == '1')
            swallow(r + 1, c, grid);
        if (r - 1 >= 0 && grid[r - 1][c] == '1')
            swallow(r - 1, c, grid);
        if (c + 1 < COLS && grid[r][c + 1] == '1')
            swallow(r, c + 1, grid);
        if (c - 1 >= 0 && grid[r][c - 1] == '1')
            swallow(r, c - 1, grid);
        return;
    }
}

