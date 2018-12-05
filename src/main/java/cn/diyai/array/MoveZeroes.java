package cn.diyai.array;

import junit.framework.Assert;
import org.junit.Test;

//将数组中的零调整到尾部
public class MoveZeroes {

    int[] nums;
    public void moveZeroes(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length;i++){
            //如果当前值是0就和后面不是0的值交换
            if(nums[i] == 0){
                for(int j = i+1; j < nums.length;j++){
                    if(nums[j] !=0){
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    //不用交换，直接将非0的值提出来，最后补零
    public void moveZeroes2(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        for(int i = count; i < nums.length;i++){
            nums[count++] = 0;
        }
    }

    @Test
    public void test(){
        nums = new int[]{3,2,2,3};
        moveZeroes(nums);
        //3,2,2,3
        ArrayUtil.printArray(nums);

        nums = new int[]{0,1,0,3,12};
        //1,3,12,0,0
        moveZeroes(nums);
        ArrayUtil.printArray(nums);

        nums = new int[]{1,1,0,3,12};
        //1,1,3,12,0
        moveZeroes(nums);
        ArrayUtil.printArray(nums);

        nums = new int[]{0,0,0,0};
        //0,0,0,0
        moveZeroes(nums);
        ArrayUtil.printArray(nums);

        nums = new int[]{0,0,0,1};
        //1,0,0,0
        moveZeroes(nums);
        ArrayUtil.printArray(nums);


        nums = new int[]{3,2,2,3};
        moveZeroes2(nums);
        //3,2,2,3
        ArrayUtil.printArray(nums);

        nums = new int[]{0,1,0,3,12};
        //1,3,12,0,0
        moveZeroes2(nums);
        ArrayUtil.printArray(nums);

        nums = new int[]{1,1,0,3,12};
        //1,1,3,12,0
        moveZeroes2(nums);
        ArrayUtil.printArray(nums);

        nums = new int[]{0,0,0,0};
        //0,0,0,0
        moveZeroes2(nums);
        ArrayUtil.printArray(nums);

        nums = new int[]{0,0,0,1};
        //1,0,0,0
        moveZeroes2(nums);
        ArrayUtil.printArray(nums);
    }
}
