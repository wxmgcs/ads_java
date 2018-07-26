package cn.diyai.character_string.exercise;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 *
 * 思路: 分前后两段,游标计数,如果大于1就丢弃,直到找到第一个只出现一次的字符
 */
public class FirstNotRepeatingChar {
    public int find(String str){

        if(str == null || str.length() == 0){
            return -1;
        }

        //第几趟
        for(int i = 0; i < str.length(); i++){
            int equalCount = 1;
            //前半段是否有
            for(int j = 0; j < i; j++){
                if(str.charAt(i) == str.charAt(j)){
                    equalCount++;
                    continue;
                }
            }

            //后半段是否有
            for(int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    equalCount++;
                    continue;
                }
            }

            System.out.println(str.charAt(i)+":"+equalCount);
            if (equalCount == 1){
                return i;
            }
        }
        return -1;
    }


    @Test
    public void test(){

        Assert.assertEquals(-1,find(""));
        Assert.assertEquals(1,find("12342345"));
        Assert.assertEquals(6,find("12142345"));
    }

}
