class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        int[] count = new int[100001];

        // Step 1: Calculate initial differences and max difference
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
            maxDiff = Math.max(maxDiff, diff);
        }

        long k = (long) k1 + k2;

        // Step 2: Greedily reduce the largest differences
        for (int v = maxDiff; v > 0 && k > 0; v--) {
            if (count[v] > 0) {
                if (k >= count[v]) {
                    k -= count[v];
                    count[v - 1] += count[v];
                    count[v] = 0;
                } else {
                    count[v - 1] += (int) k;
                    count[v] -= (int) k;
                    k = 0;
                }
            }
        }

        // Step 3: Compute final minimum sum of squared differences
        long result = 0;
        for (int v = 1; v <= maxDiff; v++) {
            if (count[v] > 0) {
                result += (long) count[v] * v * v;
            }
        }

        return result;
    }
}