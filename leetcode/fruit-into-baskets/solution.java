class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int l = 0;
        int total = 0;
        int res = 0;
        for (int r = 0; r < fruits.length; r++) {
            count.put(fruits[r], count.getOrDefault(fruits[r], 0) + 1);
            total++;
            while (count.size() > 2) {
                int f = fruits[l];
                count.put(f, count.get(f) - 1);
                total--;
                l++;
                if (count.get(f) == 0) {
                    count.remove(f);
                }
            }
            res = Math.max(res, total);
        }

        return res;
    }
}