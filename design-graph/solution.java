class Graph {
    private final Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adjList.putIfAbsent(src, new ArrayList<Integer>());
        adjList.putIfAbsent(dst, new ArrayList<Integer>());

        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!adjList.containsKey(src) || !adjList.containsKey(dst))
            return false;

        var srcAdj = adjList.get(src);

        for (var i = 0; i < srcAdj.size(); i++) {
            if (srcAdj.get(i) == dst) {
                srcAdj.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean hasPath(int src, int dst) {
        if (!adjList.containsKey(src) || !adjList.containsKey(dst))
            return false;
        
        return dfs(src, dst, new HashSet<Integer>());
    }


    private boolean dfs(int node, int target, Set<Integer> visit) {
        if (visit.contains(node)) {
            return false;
        }

        if (node == target) {
            return true;
        }

        visit = new HashSet<Integer>();
        visit.add(node);
        for (var neighbor: adjList.get(node)) {
            var intermit = dfs(neighbor, target, visit);
            if (intermit) return true; 
        }

        visit.remove(node);

        return false;
    }
}
