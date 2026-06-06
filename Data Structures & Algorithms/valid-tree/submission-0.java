class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            map.get(x).add(y);
            map.get(y).add(x);
        }

        Set<Integer> visited = new HashSet<Integer>();
        if (!isCycleDetected(0,-1,visited,map)) {
            return false;
        }

        return visited.size() == n;
    }


    static boolean isCycleDetected(int node, int parent, Set<Integer> visited, Map<Integer,List<Integer>> map) {
         if (visited.contains(node)) {
                return false;
            }
        visited.add(node);
        for (int neighborNode : map.get(node)) {
           if (neighborNode == parent) continue;

           if (!isCycleDetected(neighborNode,node,visited,map)) return false;
        }

        return true;
    }


    
}
