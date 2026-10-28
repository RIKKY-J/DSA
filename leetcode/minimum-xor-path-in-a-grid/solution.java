class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Integer dp[][][] = new Integer[n+1][m+1][1024];

        return recursion(0 , 0 , 0 , grid,dp);
    }

    private static int recursion(int i , int j , int xor ,int arr[][], Integer dp[][][]) {
        int n = arr.length;
        int m = arr[0].length;

        if(i >= n || j >= m)return Integer.MAX_VALUE;
        if(i == n-1 && j == m-1)  return xor ^ arr[i][j];
        if(dp[i][j][xor] != null) return dp[i][j][xor];

        int result = Integer.MAX_VALUE;
        
        int left = recursion(i+1 , j , xor ^ arr[i][j] , arr,dp);
        if(left != Integer.MAX_VALUE) result = Math.min(result , left);
        
        int right = recursion(i , j + 1 , xor ^ arr[i][j] , arr,dp);
        if(right != Integer.MAX_VALUE) result = Math.min(result , right);
    
        return dp[i][j][xor] = result;
    }
}