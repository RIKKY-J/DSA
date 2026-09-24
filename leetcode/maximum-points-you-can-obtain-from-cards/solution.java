class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for (int x : cardPoints) {
            total += x;
        }
        // We need to leave behind n-k consecutive cards.
        int windowSize = n - k;
        int windowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }
        int minWindow = windowSum;
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];
            minWindow = Math.min(minWindow, windowSum);
        }
        return total - minWindow;
    }
}