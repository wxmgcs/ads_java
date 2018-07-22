package cn.diyai.character_string.exercise;

import java.util.HashMap;

public class DistinctSubstring2 {
    public int longestSubstring(String A, int n) {
        // write code here
        if (A == null || A.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> pre = new HashMap<Character, Integer>();
        int max = 1;
        int[] dp = new int[A.length()];
        dp[0] = -1;
        pre.put(A.charAt(0), 0);
        for (int i = 1; i < A.length(); i++) {
            if (pre.containsKey(A.charAt(i)) && pre.get(A.charAt(i)) > dp[i - 1]) {
                dp[i] = pre.get(A.charAt(i));
            } else {
                dp[i] = dp[i - 1];
            }
            pre.put(A.charAt(i), i);
            max = Math.max(max, i - dp[i]);
        }
        return max;
    }
}
