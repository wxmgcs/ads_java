package cn.diyai.tree;

import junit.framework.TestCase;

import java.util.ArrayList;

public class BinaryHelper extends TestCase {

	/**
	 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * @param n
	 * @return
	 */
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

	/**
	 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	 */
	public double Power(double base, int exponent) {
		return Math.pow(base, exponent);
	}



	public static void main(String[] args) {
		BinaryHelper binaryHelper = new BinaryHelper();
		assertEquals(1, binaryHelper.NumberOf1(2));
		assertEquals(31, binaryHelper.NumberOf1(-3));

		System.out.println(binaryHelper.Power(3.0001, 4));



	}

}
