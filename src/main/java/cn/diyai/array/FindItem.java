package cn.diyai.array;

import junit.framework.TestCase;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindItem extends TestCase{
	
	public static boolean Find(int target,int[][] array){
		for (int i = 0; i < array.length; i++) {
            int lastIndex = array[i].length - 1;
             
            if (array[i].length == 0) {
                continue;
            }
             
            if (array[i][0] <= target && array[i][lastIndex] >= target) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
	}
	
	public void testFind(){
		int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
		assertEquals(true, FindItem.Find(3, array));
		assertEquals(false, FindItem.Find(10, array));
		
	}
	
	public void testArrayZeroLength(){
		int[][] array = {};
		assertEquals(false, FindItem.Find(3, array));
		
		int[][] array2 = {{}};
		assertEquals(false, FindItem.Find(3, array2));
		
	}
	
	public static void main(String[] args) {
		FindItem finder = new FindItem();
		finder.testFind();
		finder.testArrayZeroLength();
		
	}
	
}
