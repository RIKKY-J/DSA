class Solution {

    public int beautySum(String s) {

        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                // Add current character
                freq[s.charAt(j) - 'a']++;

                int max = 0;
                int min = Integer.MAX_VALUE;

                // Find maximum and minimum frequency
                for (int k = 0; k < 26; k++) {

                    if (freq[k] > 0) {

                        max = Math.max(max, freq[k]);
                        min = Math.min(min, freq[k]);
                    }
                }

                ans += (max - min);
            }
        }

        return ans;
    }
}