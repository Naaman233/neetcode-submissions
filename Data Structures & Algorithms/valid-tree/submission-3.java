class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0 ) return true;
        Set<Integer> hashset = new HashSet<>();

        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }

            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }

            map.get(x).add(y);
            map.get(y).add(x);

        }

        if (isCycleDetected(0,-1,hashset,map)) {
            return false;
        }
        return hashset.size() == n;
    }

    static boolean isCycleDetected(int node, int parent, Set<Integer> hashset, Map<Integer,List<Integer>> map) {
        if (hashset.contains(node)) {
            return true;
        }

        hashset.add(node);
        for (int neighborNode : map.get(node)) {
            if (parent == neighborNode) continue;

            if (isCycleDetected(neighborNode,node,hashset,map)) return true;
        }

        return false;
    }
}
