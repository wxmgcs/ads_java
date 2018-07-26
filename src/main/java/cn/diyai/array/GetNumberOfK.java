package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

public class GetNumberOfK {

    public int getNumberOfK(int [] array , int k) {
        if(array.length == 0){
            return 0;
        }

        int sum = 0;
        for(int i = 0;i < array.length; i++){
            if(array[i] == k){
                sum++;
            }
        }

        return sum;
    }

    //
    public int getNumberOfK2(int [] array , int k) {
        //以下三行不需要
//        if(array.length == 0){
//            return 0;
//        }

        int sum = 0;
        for(int i = 0;i < array.length; i++){
            if(array[i] == k){
                sum++;
            }
        }

        return sum;
    }

    @Test
    public void test(){

        Assert.assertEquals(0,getNumberOfK(new int[]{},1));
        Assert.assertEquals(1,getNumberOfK(new int[]{1},1));
        Assert.assertEquals(2,getNumberOfK(new int[]{1,2,1},1));
        Assert.assertEquals(0,getNumberOfK(new int[]{1,2,1},3));

        Assert.assertEquals(0,getNumberOfK2(new int[]{},1));
        Assert.assertEquals(1,getNumberOfK2(new int[]{1},1));
        Assert.assertEquals(2,getNumberOfK2(new int[]{1,2,1},1));
        Assert.assertEquals(0,getNumberOfK2(new int[]{1,2,1},3));
    }

}
