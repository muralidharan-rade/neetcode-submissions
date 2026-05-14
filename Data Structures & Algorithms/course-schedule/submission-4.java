class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length <= 1) {
            return true;
        }

        ArrayList<ArrayList<Integer>> adjList = createAdj(prerequisites, numCourses);
        boolean[] visited = new boolean[numCourses];

        boolean[] path = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(dfs(adjList, i, visited, path)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, boolean[] path) {
        visited[src] = true;
        path[src] = true;

        for(int n : adj.get(src)) {
            if(path[n]) {
                return true;
            }

            if(!visited[n]) {
                if(dfs(adj, n, visited, path)) {
                    return true;
                }
            }
        }

        path[src] = false;
        return false;
    }

    private ArrayList<ArrayList<Integer>> createAdj(int[][] preq, int nodes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<preq.length; i++) {
            int n = preq[i][0];
            int m = preq[i][1];

            adj.get(m).add(n);
        }

        return adj;
    }
}
