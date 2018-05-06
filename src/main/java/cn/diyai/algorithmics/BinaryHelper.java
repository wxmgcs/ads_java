package cn.diyai.algorithmics;

import junit.framework.TestCase;

import java.util.ArrayList;

public class BinaryHelper extends TestCase {

	public int NumberOf1(int n) {
		int count = 0;
		String str = Integer.toBinaryString(n);
		System.out.println(str);

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				count++;
			}
		}

		return count;
	}

	public double Power(double base, int exponent) {
		return Math.pow(base, exponent);
	}

	public void reOrderArray(int[] array) {
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

	public static void main(String[] args) {
		BinaryHelper binaryHelper = new BinaryHelper();
		assertEquals(1, binaryHelper.NumberOf1(2));
		assertEquals(31, binaryHelper.NumberOf1(-3));

		System.out.println(binaryHelper.Power(3.0001, 4));

		binaryHelper.reOrderArray(new int[] { 1, 2, 3, 4, 5 });
		binaryHelper.reOrderArray(new int[] {});

	}

}
