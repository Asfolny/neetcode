class Solution {
    public int countPaths(int[][] grid) {
        return helper(grid, 0, 0, new HashSet<>());
    }

    private int helper(int[][] grid, int r, int c, Set<String> visit) {
        int ROWS = grid.length, COLS = grid[0].length;
        if (Math.min(r, c) < 0 ||
            r == ROWS || c == COLS ||
            visit.contains(r + "," + c) || grid[r][c] == 1) {
            return 0;
        }
        if (r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        visit.add(r + "," + c);

        int count = 0;
        count += helper(grid, r + 1, c, visit);
        count += helper(grid, r - 1, c, visit);
        count += helper(grid, r, c + 1, visit);
        count += helper(grid, r, c - 1, visit);

        visit.remove(r + "," + c);
        return count;
    }
}
