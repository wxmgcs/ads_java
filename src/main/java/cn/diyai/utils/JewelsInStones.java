package cn.diyai.utils;

public class JewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        for(int i= 0; i < S.length();i++){
            char s = S.charAt(0);
            for(int j = 0; j < J.length();j++){
                char x = J.charAt(j);
                if (x == j) {
                    ++res;
                    break;
                }
            }
        }
        return res;
    }
}
