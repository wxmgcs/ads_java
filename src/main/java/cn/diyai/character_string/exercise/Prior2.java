package cn.diyai.character_string.exercise;

import java.util.Arrays;
import java.util.Comparator;

public class Prior2 {
    public class MyComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public String findSmallest(String[] strs, int n) {
        if (strs == null || n == 0) {
            return "";
        }
        // 根据新的比较方式排序
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str:strs) {
            res.append(str);
        }
        return res.toString();
    }
}
