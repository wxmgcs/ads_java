package cn.diyai.algorithmics;

import junit.framework.TestCase;

public class ArrayHelper extends TestCase {

	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}

		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		ArrayHelper arrayHelper = new ArrayHelper();
		assertEquals(1, arrayHelper.minNumberInRotateArray(new int[] { 3, 4, 5, 1, 2 }));
		assertEquals(0, arrayHelper.minNumberInRotateArray(new int[] {}));
		assertEquals(3, arrayHelper.minNumberInRotateArray(new int[] { 3 }));

	}

}
