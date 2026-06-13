class Graph {
    Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        if (!adjList.containsKey(src)) {
            adjList.put(src, new ArrayList<>());
        }
        if (!adjList.containsKey(dst)) {
            adjList.put(dst, new ArrayList<>());
        }

        List<Integer> neighbours = adjList.get(src);
        for (Integer neighbour : neighbours) {
            if (neighbour == dst) {
                return;
            }
        }
        neighbours.add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!adjList.containsKey(src)) {
            return false;
        }
        if (!adjList.containsKey(dst)) {
            return false;
        }
        List<Integer> neighbours = adjList.get(src);
        // could also use a while loop here with int i but you need practice on iterator.
        Iterator<Integer> it = neighbours.iterator();
        while (it.hasNext()) {
            Integer neighbour = it.next();
            if (neighbour == dst) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean hasPath(int src, int dst) {
        // use dfs
        Set<Integer> visited = new HashSet<>();

        return dfs(src, dst, visited);
    }

    public boolean dfs(int curr, int dst, Set<Integer> visited) {
        if (curr == dst) {
            return true;
        }
        if (visited.contains(curr)) {
            return false;
        }
        List<Integer> neighbours = adjList.get(curr);
        for (Integer neighbour : neighbours) {
            if (dfs(neighbour, dst, visited)) {
                return true;
            }
        }
        visited.add(curr);
        return false;
    }
}
