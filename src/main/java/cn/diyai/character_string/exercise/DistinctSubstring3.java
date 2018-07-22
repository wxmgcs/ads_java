package cn.diyai.character_string.exercise;

public class DistinctSubstring3 {
    public int longestSubstring(String A, int n) {
        // write code here
        if (A == null || A.length() == 0) {
            return 0;
        }
        // 记录上一次字符出现位置
        int[] map = new int[256];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
        // 初始化
        int pre = -1;  // 记录当前无重复子串的起始位置，
        int max = 0;
        // 状态转移
        for (int i = 0; i < A.length(); i++) {
            // 当上次字符出现位置，在无重复子串之后时，更新。
            if (pre < map[A.charAt(i)]) {
                pre = map[A.charAt(i)];
            }
            // 最大的子串长度的计算，当前结尾的无重复子串长度为 i - pre
            max = Math.max(max, i - pre);
            map[A.charAt(i)] = i;
        }
        return max;
    }
}
