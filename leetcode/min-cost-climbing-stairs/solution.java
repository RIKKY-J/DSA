class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = Math.min(fn(cost , 0), fn(cost, 1));
        return ans;
    }
    public int fn(int[] cost, int i){
        if(i+1 >= cost.length || i+2 >= cost.length) return cost[i];
        if(dp[i] != -1) return dp[i];
        int a = fn(cost, i+1);
        int b = fn(cost, i+2);

        return dp[i] = Math.min(a,b)+cost[i];
    }
}