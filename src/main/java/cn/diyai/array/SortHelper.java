package cn.diyai.array;

import java.util.ArrayList;

public class SortHelper {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reOrderArray(int[] array) {
        if (array.length == 0) {
            return;
        }

        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            if (val % 2 == 0) {
                evenList.add(val);
            } else {
                oddList.add(val);
            }
        }

        oddList.addAll(evenList);

        for (int i = 0; i < array.length; i++) {
            array[i] = oddList.get(i);
        }
    }

    public static void main(String[] args){
        reOrderArray(new int[] { 1, 2, 3, 4, 5 });
        reOrderArray(new int[] {});
    }
}
