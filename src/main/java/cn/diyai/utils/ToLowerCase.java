package cn.diyai.utils;

import junit.framework.Assert;
import org.junit.Test;

/**
 * 大写转小写
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        char [] arr = str.toCharArray();
        for(int i = 0; i < arr.length;i++){
            if (arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] += 32;
            }
        }
        return new String(arr);
    }

    @Test
    public void test(){
        Assert.assertEquals("hello",toLowerCase("Hello"));

    }
}
