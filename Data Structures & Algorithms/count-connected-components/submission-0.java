class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> adjscentList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjscentList.put(i , new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            adjscentList.get(a).add(b);
            adjscentList.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i,adjscentList,visited);
                count++;
            }
        }

        return count;
    }

    static void dfs(int node,Map<Integer,List<Integer>> adjscentList,boolean[] visited) {
        visited[node] = true;
        for (int neighborNode : adjscentList.get(node)) {
            if (!visited[neighborNode]) {
                dfs(neighborNode,adjscentList,visited);
            }
        }
    }
}
