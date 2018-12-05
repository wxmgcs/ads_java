package cn.diyai.array;

import org.junit.Assert;
import org.junit.Test;

public class Bit1_2Characters {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            if (bits[i] == 0){
                ++i;
            }else{
                i+= 2;
            }
        }
        return i == n - 1;
    }


    public boolean isOneBitCharacter2(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            i += bits[i] + 1;
        }
        return i == n - 1;
    }

    public boolean isOneBitCharacter3(int[] bits) {
        if(bits == null || bits.length == 0){
            return false;
        }

        if(bits[bits.length -1] != 0){
            return false;
        }

        int[] result = new int[bits.length];

        return isValid(bits , bits.length -1, result);

    }

    public boolean isValid(int[] bits , int n , int[] result){
        if(result[n] != 0){
            return result[n] == 1;
        }
        boolean valid = true;

        for(int i = n-1; i>=0 ; i--){
            if(bits[i] == 0){
                valid = (isValid(bits , n-1 , result) || isValid(bits , n-2 , result));
                result[n] = valid ? 1 : -1;
                return valid;
            }else if(i -1 >=0 && bits[i-1] ==1){
                valid = isValid(bits , n-2, result);
                result[n] = valid ? 1 : -1;
                return valid;
            }
            result[n] = -1;
            return false;
        }
        return valid;
    }

    @Test
    public void test(){


        Assert.assertEquals(false,isOneBitCharacter(new int[]{ 1, 1, 1, 0}));
        Assert.assertEquals(false,isOneBitCharacter2(new int[]{ 1, 1, 1, 0}));

    }
}
