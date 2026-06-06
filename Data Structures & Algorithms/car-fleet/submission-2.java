class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pos[] fleetDetails = new Pos[n];
        for (int i = 0; i < n; i++) {
            fleetDetails[i] = new Pos(position[i],speed[i]);
        }
        Arrays.sort(fleetDetails,(a,b) -> b.position - a.position);
        //int max_time = Integer.MIN_VALUE;
        double max_time = -1.0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            Pos current = fleetDetails[i];
            double time = (double)(target - current.position) / current.speed;
            if (time > max_time) {
                res++;
                max_time = time;
            }

        } 

        return res;
    }
}

class Pos {
    int position;
    int speed;
    Pos(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}
