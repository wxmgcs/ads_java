package cn.diyai.character_string;

public class Replacement2 {
    public String replaceSpace(String iniString, int length) {
        // write code here
        int count = 0;
        for (int i = 0; i < iniString.length(); i++) {
            if (iniString.charAt(i) == ' ') {
                count++;
            }
        }
        char[] str = {'%', '2', '0'};
        char[] res = new char[iniString.length() + count * (str.length - 1)];
        int j = res.length - 1;
        for (int i = iniString.length() - 1; i >= 0; i--) {
            if (iniString.charAt(i) != ' ') {
                res[j] = iniString.charAt(i);
                j--;
            } else {
                res[j - 2] = '%';
                res[j - 1] = '2';
                res[j] = '0';
                j -= 3;
            }
        }
        return String.valueOf(res);
    }
}
