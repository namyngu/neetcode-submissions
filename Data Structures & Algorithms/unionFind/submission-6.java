class UnionFind {
    Map<Integer,Integer> parent;
    Map<Integer, Integer> rank;
    int numComponents;

    public UnionFind(int n) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        numComponents = n;

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

        // Another optimization that balances the tree.
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
        numComponents--;
        return true;
    }

    public int getNumComponents() {
        return numComponents;
    }
}
