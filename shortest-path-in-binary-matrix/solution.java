class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;

        var ROWS = grid.length;
        var COLS = grid[0].length;
        var length = 1;
        var visited = new int[ROWS][COLS];
        var queue = new ArrayDeque<int[]>();

        queue.add(new int[2]);
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            var queueLen = queue.size();
            for (int i = 0; i < queueLen; i++) {
                var point = queue.poll();
                int r = point[0], c = point[1];
                if (r == ROWS-1 && c == COLS-1) {
                    return length;
                }

                var neighbors = new int[][]{
                    {r, c + 1}, {r, c - 1},
                    {r + 1, c}, {r - 1, c},
                    {r + 1, c + 1}, {r + 1, c - 1},
                    {r - 1, c + 1}, {r - 1, c - 1}
                };

                for (var neighbor : neighbors) {
                    r = neighbor[0];
                    c = neighbor[1];
                    if (Math.min(r, c) < 0 ||
                        r == ROWS ||
                        c == COLS ||
                        visited[r][c] == 1 ||
                        grid[r][c] == 1) {
                        continue;
                    }
                    queue.add(new int[] {r, c});
                    visited[r][c] = 1;
                }
            }

            length++;
        }
        
        return -1;
    }
}
