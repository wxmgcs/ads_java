package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class FindAllNumbersDisappeared {

    //思路: 空数组 -> 遍历赋值 -> 找到元素为0的索引+1
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ret = new ArrayList<>();
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            temp[nums[i]-1] = nums[i];
        }

        for(int i = 0; i < nums.length;i++){
            if(temp[i] == 0){
                ret.add(i+1);
            }
        }

        return ret;
    }

    @Test
    public void test(){

        List<Integer> ret = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for(Integer i : ret){
            System.out.println(i);
        }

        System.out.println();

        ret = findDisappearedNumbers(new int[]{4,3,1,7,8,2,3,1});
        for(Integer i : ret){
            System.out.println(i);
        }

        System.out.println();

        ret = findDisappearedNumbers(new int[]{2,3,1,7,8,4,3,1});
        for(Integer i : ret){
            System.out.println(i);
        }

        System.out.println();

        ret = findDisappearedNumbers(new int[]{2,3,1,4,3,1});
        for(Integer i : ret){
            System.out.println(i);
        }
    }
}
