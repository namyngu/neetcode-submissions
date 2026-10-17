// Idea: We want to be able to map every email to the index of the account it belongs to.
// Before we can do that we want to first union all the accounts (specifically the account's index)

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> emailToAcc = new HashMap<>();      // email -> index of acc

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            int rootAccount = uf.findRoot(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAcc.containsKey(email)) {
                    // Email already belongs to another account.
                    uf.union(i, emailToAcc.get(email));         // union the two accounts
                }
                else {
                    emailToAcc.put(email, i);
                }
            }
        }

        // Now map all emails from emailToAcc to a root account.
        Map<Integer, List<String>> mergedAccounts = new HashMap<>();                // index of account -> list of emails.

        for (Map.Entry<String, Integer> entry : emailToAcc.entrySet()) {
            String email = entry.getKey();
            int accId = entry.getValue();
            int rootAcc = uf.findRoot(accId);
            if (mergedAccounts.containsKey(rootAcc)) {
                List<String> emails = mergedAccounts.get(rootAcc);
                emails.add(entry.getKey());
            }
            else {
                    mergedAccounts.put(rootAcc, new ArrayList<>(List.of(email))
                );
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : mergedAccounts.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String name = accounts.get(entry.getKey()).get(0);

            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            res.add(account);
        }

        return res;
    }
}

// Used to link accounts together (not emails)
class UnionFind {
    int[] parentA;                      // the index of parentA corresponds to index of the accounts list.
    int[] rank;                         // the value of parentA[i] is the index of its parent account.

    public UnionFind(int n) {
        parentA = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parentA[i] = i;
            rank[i] = 0;
        }
    }

    int findRoot(int acc) {
        if (parentA[acc] == acc) {
            return acc;
        }
        parentA[acc] = findRoot(parentA[acc]);
        return parentA[acc];
    }

    boolean union(int a1, int a2) {
        int root1 = findRoot(a1);
        int root2 = findRoot(a2);

        if (root1 == root2) {
            return false;
        }
        if (rank[root1] < rank[root2]) {
            parentA[root1] = root2;
        }
        else if (rank[root1] > rank[root2]) {
            parentA[root2] = root1;
        }
        else {
            parentA[root2] = root1;
            rank[root1]++;
        }
        return true;
    }
}