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

    //TODO fixme
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
                    int index = 0;
                    if(nRows % 2 == 0){
                        index = i+(nRows)*j;
                    }else{
                        index = i+(nRows+1)*j;
                    }
                    if( index < s.length()){
                        ret = ret + s.charAt(index);
                    }

                }
                //第2,4,6,7行
            }else{
                for(int j = 0; j < s.length()/(nRows-1);j++){
                    int index = 0;
                    if(nRows % 2 == 0){
                        index = i+(nRows-1)*j;
                    }else{
                        index = i+(nRows)*j;
                    }

                    if( index < s.length()){
                        ret = ret + s.charAt(index);
                    }
                }
            }
        }

        return ret;
    }

    public String convert2(String s,int nRows){
        int gap = nRows + nRows - 2;
        if(gap==0)
            return s;
        char[]  sb = new char[s.length()];
        int count = 0;
        for(int i = 0;i<nRows;i++)
        {
            if(gap!=0 && gap!=2*nRows-2)
            {
                int k = i,t=i+gap;
                for(;count<sb.length && (k<s.length() || t<s.length());k=k+2*nRows-2,t=t+2*nRows-2)
                {
                    if(count<sb.length &&k < s.length())
                        sb[count++] = s.charAt(k);
                    if(count<sb.length &&t<s.length())
                        sb[count++] = s.charAt(t);
                }
            }
            else
            {
                for(int k = i;count<sb.length && k<s.length();k=k+2*nRows-2)
                    sb[count++]= s.charAt(k);
            }
            gap = gap-2;
        }
        return new String(sb);
    }

    @Test
    public void test(){

//        Assert.assertEquals("A",convert("A",2));
//        Assert.assertEquals("AB",convert("AB",2));
//        Assert.assertEquals("AB",convert("AB",1));
//        Assert.assertEquals("ACB",convert("ABC",2));
//        Assert.assertEquals("PAHNAPLSIIGYIR",convert("PAYPALISHIRING",3));

        Assert.assertEquals("A",convert2("A",2));
        Assert.assertEquals("AB",convert2("AB",2));
        Assert.assertEquals("AB",convert2("AB",1));
        Assert.assertEquals("ACB",convert2("ABC",2));
        Assert.assertEquals("PAHNAPLSIIGYIR",convert2("PAYPALISHIRING",3));

    }
}
