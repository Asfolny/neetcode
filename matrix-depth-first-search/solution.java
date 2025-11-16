class Solution {
    List<List<String>> res;
    public int countPaths(int[][] grid) {
        res = new ArrayList<>();
        var path = new LinkedHashSet<String>();
        dfs(0, 0, path, grid);
        return res.size();
    }

    private void dfs(int r, int c, Set<String> path, int[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;
        if (grid[rows-1][cols-1] == 1 || // special case, if the bottom right is NOT a valid path
            Math.min(r, c) < 0 || r >= rows || c >= cols ||
            path.contains(String.format("%d,%d", r, c)) || grid[r][c] == 1) {
            return;
        }

        if (r == rows-1 && c == cols-1) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(String.format("%d,%d", r, c));
        dfs(r + 1, c, path, grid);
        dfs(r - 1, c, path, grid);
        dfs(r, c + 1, path, grid);
        dfs(r, c - 1, path, grid);
        path.remove(String.format("%d,%d", r, c));
    }
}
