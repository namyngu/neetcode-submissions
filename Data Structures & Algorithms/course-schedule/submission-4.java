class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // map course to its prerequisites
        Map<Integer, List<Integer>> adjList = new HashMap<>();      
        for (int i = 0; i < prerequisites.length; i++) {
            if (!adjList.containsKey(prerequisites[i][0])) {
                adjList.put(prerequisites[i][0], new ArrayList<>());
            }
            if (!adjList.containsKey(prerequisites[i][1])) {
                adjList.put(prerequisites[i][1], new ArrayList<>());
            }
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Edge case a course may not have any pre-requisites
        for (int course = 0; course < numCourses; course++) {
            if (!adjList.containsKey(course)) {
                adjList.put(course, new ArrayList<>());
            }
        }


        // DFS solution, for each course go to each of its neighbors and check if there's a cycle.
        for (int course = 0; course < numCourses; course++) {
             Set<Integer> visited = new HashSet<>();
             if (!dfs(course, adjList, visited)) {
                return false;
             }
        }
        return true;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(course)) {
            return false;
        }
        visited.add(course);
        List<Integer> neighbors = adjList.get(course);

        for (Integer neighbor : neighbors) {
            if (!dfs(neighbor, adjList, visited)) {
                return false;
            }
        }
        
        visited.remove(course);     // important
        adjList.put(course, new ArrayList<>());
        return true;
    }
}
