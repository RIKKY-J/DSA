class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;

        int cnt = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        while(r<n){
            if(map.getOrDefault(s.charAt(r), 0) > 0){
                cnt++;
            }
            map.put(s.charAt(r) , map.getOrDefault(s.charAt(r), 0) - 1);

            while(cnt == m){
                if(r - l + 1 < minLen){
                    minLen = r-l + 1;
                    startIdx  = l;
                }
                char leftC = s.charAt(l);

                map.put(leftC, map.getOrDefault(leftC, 0) + 1);
                if(map.get(leftC) > 0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
        if(startIdx == -1) return "";
        return s.substring(startIdx, startIdx + minLen);
    }
}