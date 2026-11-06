class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        // Left to right
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                arr[i + 1] = arr[i] + 1;
            }
        }
        // Right to left
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                arr[i - 1] = Math.max( arr[i - 1], arr[i] + 1 );
            }
        }
        int ans = 0;
        for (int candy : arr) ans += candy;
        return ans;
    }
}
