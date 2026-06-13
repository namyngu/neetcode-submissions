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
        // use bfs (can also use dfs)
        int length = 0;     // don't need it but optional.
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.addLast(src);
        visited.add(src);

        while (!q.isEmpty()) {
            int qLength = q.size();
            for (int i = 0; i < qLength; i++) {
                int curr = q.removeFirst();
                if (curr == dst) {
                    return true;
                }

                // add neighbours to the queue
                List<Integer> neighbours = adjList.get(curr);
                for (Integer neighbour : neighbours) {
                    if (visited.contains(neighbour)) {
                        continue;
                    }
                    q.addLast(neighbour);
                    visited.add(neighbour);
                }
            }
            length++;
        }
        return false;
    }
}
