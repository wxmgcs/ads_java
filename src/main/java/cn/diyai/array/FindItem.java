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




	/**
	 * 对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
	 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
	 * @param arr
	 * @param n
	 * @param num
	 * @return
	 */
	public int findPos(int[] arr, int n, int num) {
		// write code here
		for(int i = 0; i < n; i++){
			if(arr[i] == num){
				return i;
			}
		}

		return -1;
	}


	/**
	 * 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
	 * 如果所有位置上的数都不满足条件，返回-1。
	 给定有序数组arr及它的大小n，请返回所求值。
	 * @param arr
	 * @param n
	 * @return
	 */
	public int findPos(int[] arr, int n) {
		// write code here
		for(int i = 0; i < n;i++){
			if(arr[i] > i){
				return -1;
			}

			if(arr[i] == i){
				return i;
			}
		}
		return -1;

	}

	/**
	 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。
	 * arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
	 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
	 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
	 *
	 * 给定无序数组arr，已知arr中任意两个相邻的数都不相等，写一个函数，
	 * 只需返回arr中任意一个局部最小出现的位置即可。

	 * @param arr
	 * @return
	 */
	public int getLessIndex(int[] arr) {
		int len = arr.length;

		if (len == 1){
			return 0;
		}

		if (len == 0) return -1;
		if (len == 1) return 0;
		if (arr[0] < arr[1]) return 0;
		if (arr[len-1] < arr[len-2]) return len-1;
		int result = getLess(arr, 1, len-2);
		return result;

	}

	private int getLess(int[] arr, int left, int right) {
		while (left <= right) {
			int mid = left+(right-left)/2;
			if (arr[mid+1] > arr[mid] && arr[mid-1] > arr[mid]) {
				return mid;
			}else if (arr[mid] > arr[mid-1]) {
				right = mid-1;
			}else if (arr[mid] > arr[mid+1]) {
				left = mid+1;
			}
		}
		return -1;
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

	public void testFindPos(){
//		[1,2,3,3,4],5,3
		assertEquals(2,findPos(new int[]{1,2,3,3,4},5,3));
	}

	public void testFindPos2(){
		assertEquals(2,findPos(new int[]{-1,0,2,3},4));
	}

	public void testgetLessIndex(){
		assertEquals(0,getLessIndex(new int[]{1}));
		assertEquals(0,getLessIndex(new int[]{3,2,9,2,1,4,0,10,9,0,8,3,5,6,7,1,9,2,4,0,7}));
	}


}
