class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int n = cardPoints.length;
        for(int i : cardPoints){
            sum += i;
        }
        int left = 0;

        for(int right = 0; right <n && right < k; right++){
            int start = 0;
            for(int i = 0; i<right; i++){
                start += cardPoints[i];
            }
            int end = 0;
            int x = n-k+right;
            for(int j =x; j <n ; j++ ){
                end += cardPoints[j];
            }
            ans = Math.max(ans, start + end);
        }
        return ans;
    }
}
