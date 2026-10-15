class UnionFind {
    Map<Integer,Integer> parent;
    Map<Integer, Integer> rank;

    public UnionFind(int n) {
        parent = new HashMap<>();
        rank = new HashMap<>();

        for (int i = 0; i < n; i++) {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    // Find the root of x
    public int find(int x) {
        int p = parent.get(x);
        if (x != p) {
            parent.put(x, find(p));     // path compression (an optimization)
        }
        return parent.get(x);
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (rank.get(rootX) < rank.get(rootY)) {
            parent.put(rootX, rootY);
        }
        else if (rank.get(rootX) > rank.get(rootY)) {
            parent.put(rootY, rootX);
        }
        else {
            parent.put(rootY, rootX);
            rank.put(rootX, rank.get(rootX) + 1);
        }
        return true;
    }

    public int getNumComponents() {
        Set<Integer> set = new HashSet<>();
        for (Integer key : parent.keySet()) {
            set.add(find(key));
        }
        return set.size();
    }


}
