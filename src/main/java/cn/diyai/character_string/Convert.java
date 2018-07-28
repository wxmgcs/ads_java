package cn.diyai.character_string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * The string"PAYPALISHIRING"is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line:"PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3)should return"PAHNAPLSIIGYIR".

 */
public class Convert {

    public String  convert(String s, int nRows){
        if(s.length() < nRows){
            return s;
        }

        if (nRows == 1){
            return  s;
        }

        String ret = "";
        //第几行
        for(int i = 0 ; i < nRows; i++){
            //第1,3,5行
            if(i % 2 == 0){
                // 0 4 8 12
                for(int j = 0; j < s.length()/nRows+1;j++){
                    
                    int index = i+(nRows+1)*j;
                    if( index < s.length()){
                        ret = ret + s.charAt(index);
                    }

                }
                //第2,4,6,7行
            }else{
                for(int j = 0; j < s.length()/(nRows-1)+1;j++){
                    int index = i+(nRows-1)*j;
                    if( index < s.length()){
                        ret = ret + s.charAt(index);
                    }
                }
            }
        }

        return ret;
    }

    @Test
    public void test(){

        Assert.assertEquals("PAHNAPLSIIGYIR",convert("PAYPALISHIRING",3));
        Assert.assertEquals("A",convert("A",2));
        Assert.assertEquals("AB",convert("AB",2));
        Assert.assertEquals("AB",convert("AB",1));
        Assert.assertEquals("ACB",convert("ABC",2));

    }
}
