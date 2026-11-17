class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;
        dp[n] = 0;
        dp[n-1] = 1;

        dp[n-2] = 1;

        for(int i = n-3; i >= 0; i--){
            dp[i] = dp[i+1]+ dp[i+2]+ dp[i+3];
        }
        return dp[0];
    }
}