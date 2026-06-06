class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<int[]>> adj_map = new HashMap<>();
        for (int[] i : times) {
            int sourceNode = i[0];
            int targetNode = i[1];
            int latency = i[2];

            if (!adj_map.containsKey(sourceNode)) {
                 adj_map.put(sourceNode, new ArrayList<>() );

            }
            adj_map.get(sourceNode).add(new int[]{targetNode,latency});
        }

        HashMap<Integer,Integer> dist = new HashMap<Integer,Integer>();
        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);

        }
        dfs(k,0,adj_map,dist);
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    static void dfs(int node, int time, HashMap<Integer,List<int[]>> adj,HashMap<Integer,Integer> dist){
        if (time >= dist.get(node)) return;
        dist.put(node,time);
        if (!adj.containsKey(node)) return;

        for (int[] m : adj.get(node)) {
            dfs(m[0], m[1] + time, adj, dist);
        }

    }
}
