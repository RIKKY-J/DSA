class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int i = n - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }

            StringBuilder temp = new StringBuilder();
            while (i >= 0 && s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                i--;
            }

            if (sb.length() == 0) {
                sb.append(temp.reverse());
            } else {
                sb.append(' ');
                sb.append(temp.reverse());
            }
        }
        return sb.toString();
    }
}