class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n];
        int[] out = new int[n];
        for(int x  =0; x< trust.length; x++){
            int i = trust[x][0];
            int j = trust[x][1];
            out[i-1]++;
            in[j-1]++;
        }
        int x = -1;
        for(int i =0; i< n; i++){
            if(in[i] == n-1) x = i+1; 
        }
        int y = -1;
        for(int i =0; i< n; i++){
            if(out[i] == 0) y = i+1; 
        }
        if(x == y) return x;
        else return -1;
    }
}