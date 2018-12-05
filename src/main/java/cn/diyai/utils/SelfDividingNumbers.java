package cn.diyai.utils;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//找出可以自除的数列
//For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
public class SelfDividingNumbers {


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> dividingNumbers = new ArrayList<>();
        for(int i = left;i <= right;i++){
            String str = String.valueOf(i);
            char[] arrs = str.toCharArray();
            boolean isNum = true;
            for(int j = 0; j < arrs.length;j++){
                int bit = Integer.parseInt(arrs[j]+"");
                if(bit == 0 || i % bit != 0){
                    isNum = false;
                    break;
                }
            }

            if(isNum){
                dividingNumbers.add(i);
            }
        }
        return dividingNumbers;
    }

    public List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> dividingNumbers = new ArrayList<>();
        for(int i = left;i <= right;i++){
            boolean isNum = true;
            if(i > 9){
                String str = String.valueOf(i);
                char[] arrs = str.toCharArray();
                for(int j = 0; j < arrs.length;j++){
                    int bit = Integer.parseInt(arrs[j]+"");
                    if(bit == 0 || i % bit != 0){
                        isNum = false;
                        break;
                    }
                }
            }

            if(isNum){
                dividingNumbers.add(i);
            }
        }
        return dividingNumbers;
    }


    @Test
    public void test(){
        List<Integer> tt =  selfDividingNumbers(1,22);

        int[] exceptd = new int[]{1,2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22};
        for(int i = 0; i < exceptd.length;i++){
            Assert.assertEquals(exceptd[i],(int)tt.get(i));
        }

        tt =  selfDividingNumbers(1,1);

        exceptd = new int[]{1};
        for(int i = 0; i < exceptd.length;i++){
            Assert.assertEquals(exceptd[i],(int)tt.get(i));
        }

        tt =  selfDividingNumbers2(1,22);

        exceptd = new int[]{1,2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22};
        for(int i = 0; i < exceptd.length;i++){
            Assert.assertEquals(exceptd[i],(int)tt.get(i));
        }

        tt =  selfDividingNumbers2(1,1);

        exceptd = new int[]{1};
        for(int i = 0; i < exceptd.length;i++){
            Assert.assertEquals(exceptd[i],(int)tt.get(i));
        }
    }
}
