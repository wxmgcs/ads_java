package cn.diyai.character_string.exercise;

public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        // write code here
        if (A == null || A.length() == 0) {
            return 0;
        }
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        int pre = -1;
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            if (pre < map[A.charAt(i)]) {
                pre = map[A.charAt(i)];
            }
            max = Math.max(max, i - pre);
            map[A.charAt(i)] = i;
        }
        return max;
    }

}
