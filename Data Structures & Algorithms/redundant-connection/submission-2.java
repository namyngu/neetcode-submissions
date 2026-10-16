class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int EDGES = edges.length;
        UnionFind uf = new UnionFind(EDGES);
        int[] res = new int[2];

        for (int i = 0; i < EDGES; i++) {
            if (!uf.union(edges[i][0], edges[i][1])) {
                res = edges[i];
            }
        }
        return res;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int findRoot(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = findRoot(parent[x]);        // path compression
        return parent[x];
    }

    boolean isSameComponent(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

    boolean union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if (rootX == rootY) {
            return false;
        }

        // Union by Rank
        // attempts to balance tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        }
        else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        }
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
