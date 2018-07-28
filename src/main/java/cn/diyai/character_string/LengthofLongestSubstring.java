package cn.diyai.character_string;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * 找到字符串中长度最长的重复子串，返回该子串的长度
 */
public class LengthofLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        return 0;
    }


    @Test
    public void test(){
        Assert.assertEquals(3,lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1,lengthOfLongestSubstring("bbbbb"));
    }

}
